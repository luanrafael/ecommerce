package org.fatec.les.controller.managedbean;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.http.HttpSession;

import org.fatec.les.controller.utils.jsfUtils;
import org.fatec.les.repositorio.ClienteRepositorio;

@ManagedBean
@SessionScoped
public class LoginMB implements Serializable{

	private ClienteRepositorio clienteRepositorio;
	private String email;
	private String senha;
	private boolean autorizado;

	public LoginMB() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean isAutorizado() {
		return autorizado;
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

	public void setAutorizado(boolean autorizado) {
		this.autorizado = autorizado;
	}

	public void actionLogar() {
		clienteRepositorio = new ClienteRepositorio();
		autorizado = clienteRepositorio.logar(email, senha);
		if (!autorizado) {
			jsfUtils.addError("=( Email ou Senha incorretos, tente novamente!");
		} else {
			try {
				FacesContext contexto = FacesContext.getCurrentInstance();
				HttpSession sessao = (HttpSession) contexto
						.getExternalContext().getSession(false);
				sessao.setAttribute("id", email);
				jsfUtils.redirecionar("../../index.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void actionLogout() {
		FacesContext contexto = FacesContext.getCurrentInstance();
		HttpSession sessao = (HttpSession) contexto.getExternalContext()
				.getSession(false);
		sessao.invalidate();
		try {
			jsfUtils.redirecionar("../../index.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void verificarAutorizacao(ComponentSystemEvent e) {
		if (!autorizado) {
			try {
				jsfUtils.redirecionar("/ecommerce/view/login/login.xhtml");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
