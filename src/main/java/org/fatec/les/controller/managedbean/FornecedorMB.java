package org.fatec.les.controller.managedbean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.fatec.les.controller.util.MsgUtil;
import org.fatec.les.model.entity.FornecedorEntity;
import org.fatec.les.repositorio.FornecedorRepositorio;

@ManagedBean
@ViewScoped
public class FornecedorMB implements Serializable {

	
	private FornecedorEntity fornecedor;
		
	public FornecedorMB() {
		fornecedor = new FornecedorEntity();
	}
	
	public FornecedorEntity getfornecedor() {
		return  fornecedor;
	}

	public void setfornecedor(FornecedorEntity fornecedor) {
		this.fornecedor = fornecedor;
	}	
	
	public void actionCadastrarFornecedor(){
		FornecedorRepositorio repositorio = new FornecedorRepositorio();
		repositorio.persist(fornecedor);
		MsgUtil.addInfo("Fornecedor inserido com sucesso!");
	}

}
