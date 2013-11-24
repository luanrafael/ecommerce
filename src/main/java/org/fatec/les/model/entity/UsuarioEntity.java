package org.fatec.les.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;


@Entity
public class UsuarioEntity {

	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique=true, length=20)
	private String login;
	
	@Transient
	private boolean autorizado;
		
	@Column(length=18)
	private String senha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean getAutorizado(){
		return autorizado;
	}
	
	public void setAutorizado(boolean autorizado){
		this.autorizado = autorizado;
	}
	
}
