package org.fatec.les.model.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario {

	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique=true, length=20)
	private String login;
	
	@Column(length=18)
	private String senha;

	public Long getId() {
		return id;
	}
<<<<<<< HEAD
=======

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

	
>>>>>>> b7e9751fe21d3292650cc329a09b531459f2de50
}
