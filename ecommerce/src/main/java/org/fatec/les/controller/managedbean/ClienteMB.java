package org.fatec.les.controller.managedbean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.fatec.les.controller.util.MsgUtil;
import org.fatec.les.model.entity.ClienteEntity;
import org.fatec.les.model.entity.EnderecoEntity;
import org.fatec.les.repositorio.ClienteRepositorio;

import com.timgroup.jgravatar.Gravatar;

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
	}

	public EnderecoEntity getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoEntity endereco) {
		this.endereco = endereco;
	}
	
}
