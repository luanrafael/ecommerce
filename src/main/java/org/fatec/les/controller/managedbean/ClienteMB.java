package org.fatec.les.controller.managedbean;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.fatec.les.controller.util.MsgUtil;
import org.fatec.les.model.entity.ClienteEntity;
import org.fatec.les.model.entity.EnderecoEntity;
import org.fatec.les.repositorio.ClienteRepositorio;

@ManagedBean
@ViewScoped
public class ClienteMB implements Serializable {

	
	private ClienteEntity cliente;
	private EnderecoEntity endereco;
		
	public ClienteMB() {
		cliente = new ClienteEntity();
		endereco = new EnderecoEntity();
	}
	
	public ClienteEntity getCliente() {
		return  cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}	
	
	public void actionCadastrarCliente(){
		ClienteRepositorio cr = new ClienteRepositorio();
		cliente.setEndereco(endereco);
		cr.persist(cliente);
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
	
}
