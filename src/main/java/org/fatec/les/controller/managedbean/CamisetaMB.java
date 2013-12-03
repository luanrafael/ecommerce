package org.fatec.les.controller.managedbean;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import org.fatec.les.controller.utils.jsfUtils;
import org.fatec.les.model.entity.CamisetaEntity;
import org.fatec.les.repositorio.CamisetaRepositorio;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean
@SessionScoped
public class CamisetaMB implements Serializable {

	private CamisetaEntity camisetaEntity;
	private CamisetaRepositorio camisetaRepositorio;
	private UploadedFile file;
	private List<CamisetaEntity> listaCamisetas;

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public CamisetaEntity getCamisetaEntity() {
		return camisetaEntity;
	}

	public void setCamisetaEntity(CamisetaEntity camisetaEntity) {
		this.camisetaEntity = camisetaEntity;
	}

	public CamisetaRepositorio getCamisetaRepositorio() {
		return camisetaRepositorio;
	}

	public void setCamisetaRepositorio(CamisetaRepositorio camisetaRepositorio) {
		this.camisetaRepositorio = camisetaRepositorio;
	}

	public CamisetaMB() {
		camisetaEntity = new CamisetaEntity();
		camisetaRepositorio = new CamisetaRepositorio();
	}

	public void actionCadastrarCamiseta() {
		try {
			jsfUtils.redirecionar("upload.xhtml");
		} catch (IOException e) {
			try {
				jsfUtils.redirecionar("nova-camisa.xhtml?msg=Falha no upload da imagem!");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	public void upload(FileUploadEvent event) {
		String msgEr = "Favor Preencher todos os campos!";
		if (!camisetaEntity.hasNulo(msgEr)) {
			try {
				jsfUtils.redirecionar("nova-camisa.xhtml?msg=" + msgEr);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {

			file = event.getFile();
			if (file != null) {
				FacesMessage msg = new FacesMessage("Succesful",
						file.getFileName() + " is uploaded.");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				ByteArrayOutputStream bytesImg = new ByteArrayOutputStream();
				try {
					byte[] byteArray = file.getContents();
					bytesImg.close();
					camisetaEntity.setImagem(byteArray);
					camisetaRepositorio.persist(camisetaEntity);
					camisetaEntity = null;
					jsfUtils.redirecionar("../../index.xhtml?msg=Produto cadastrado com sucesso!");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void listarCamisetas(ComponentSystemEvent ev) {
		setListaCamisetas(camisetaRepositorio.loadAll());
		getListaCamisetas();
	}

	public List<CamisetaEntity> getListaCamisetas() {
		return listaCamisetas;
	}

	public void setListaCamisetas(List<CamisetaEntity> listaCamisetas) {
		this.listaCamisetas = listaCamisetas;
	}
}
