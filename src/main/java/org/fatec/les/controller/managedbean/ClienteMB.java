package org.fatec.les.controller.managedbean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.fatec.les.controller.utils.MsgUtil;
import org.fatec.les.model.entity.ClienteEntity;
import org.fatec.les.model.entity.EnderecoEntity;
import org.fatec.les.repositorio.ClienteRepositorio;

@ManagedBean
@ViewScoped
public class ClienteMB implements Serializable {
	

	private ClienteEntity cliente;
	private EnderecoEntity endereco;
	private List<ClienteEntity> listaClientes;
	private ClienteRepositorio clienteRepositorio;
	public ClienteMB() {
		cliente = new ClienteEntity();
		endereco = new EnderecoEntity();
		clienteRepositorio = new ClienteRepositorio();
	}
	
	public ClienteEntity getCliente() {
		return  cliente;
	}	

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}	
	
	public void actionCadastrarCliente(){
		
		cliente.setEndereco(endereco);
		clienteRepositorio.persist(cliente);
		MsgUtil.addInfo("Cliente Inserido com sucesso!");
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("../../index.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public EnderecoEntity getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoEntity endereco) {
		this.endereco = endereco;
	}
	
	public List<ClienteEntity> getListaClientes() {
	
		return clienteRepositorio.loadAll();
	}
	
}
