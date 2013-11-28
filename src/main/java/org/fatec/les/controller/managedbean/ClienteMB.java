package org.fatec.les.controller.managedbean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.fatec.les.controller.utils.jsfUtils;
import org.fatec.les.model.entity.ClienteEntity;
import org.fatec.les.model.entity.EnderecoEntity;
import org.fatec.les.repositorio.ClienteRepositorio;

@ManagedBean
@SessionScoped
public class ClienteMB implements Serializable {
	

	private ClienteEntity cliente;
	private ClienteEntity clienteEdt;
	private EnderecoEntity endereco;
	private List<ClienteEntity> listaClientes;
	private ClienteRepositorio clienteRepositorio;
	private long id;
	
	private String email;
	private String senha;
	
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
		try {
			jsfUtils.redirecionar("../../index.xhtml");
			jsfUtils.addInfo("Cliente Inserido com sucesso!");
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
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<ClienteEntity> getListaClientes() {
	
		return clienteRepositorio.loadAll();
	}

	public void setListaClientes(List<ClienteEntity> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	public void actionEditar(){
		clienteEdt = clienteRepositorio.load(id);
		try {
			jsfUtils.redirecionar("clienteEditar.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ClienteEntity getClienteEdt() {
		return clienteEdt;
	}

	public void setClienteEdt(ClienteEntity clienteEdt) {
		this.clienteEdt = clienteEdt;
	}
	
	public void actionAtualizarCliente(){
		clienteRepositorio.merge(clienteEdt);
	}
}
