package org.fatec.les.controller.managedbean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.http.HttpSession;

import org.fatec.les.controller.utils.jsfUtils;
import org.fatec.les.model.entity.ClienteEntity;
import org.fatec.les.model.entity.EnderecoEntity;
import org.fatec.les.repositorio.ClienteRepositorio;

@ManagedBean
@SessionScoped
public class ClienteMB implements Serializable {
	

	private ClienteEntity cliente;
	private EnderecoEntity endereco;
	private List<ClienteEntity> listaClientes;
	private ClienteRepositorio clienteRepositorio;
	
	private String email;
	private String senha;
	
	private boolean autorizado;
	
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
		jsfUtils.addInfo("Cliente Inserido com sucesso!");
		try {
			jsfUtils.redirecionar("../../index.xhtml");
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
		try {
			jsfUtils.redirecionar("clienteEditar.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean isAutorizado() {
		return autorizado;
	}

	public void setAutorizado(boolean autorizado) {
		this.autorizado = autorizado;
	}

	public void actionlogar(){

		autorizado = clienteRepositorio.logar(email,senha);
		if(!autorizado){
			jsfUtils.addError("=( Email ou Senha incorretos, tente novamente!");
		} else {
			try {
				FacesContext contexto = FacesContext.getCurrentInstance();
				HttpSession sessao = (HttpSession) contexto.getExternalContext().getSession(false);
				sessao.setAttribute("id", cliente.getId());
				jsfUtils.redirecionar("../../index.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void actionLogout(){
		FacesContext contexto = FacesContext.getCurrentInstance();
		HttpSession sessao = (HttpSession) contexto.getExternalContext().getSession(false);
		sessao.invalidate();
		try {
			jsfUtils.redirecionar("../../index.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void verificarAutorizacao(ComponentSystemEvent e){
		if(!autorizado) {
			try {
				jsfUtils.redirecionar("/ecommerce/view/login/login.xhtml");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public void actionAtualizarCliente(){
		
	}
}
