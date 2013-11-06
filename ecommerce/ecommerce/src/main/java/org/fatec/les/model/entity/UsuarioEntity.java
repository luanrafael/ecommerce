package org.fatec.les.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UsuarioEntity {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique=true, length=20)
	private String login;
	
	@Column(length=18)
	private String senha;

	@OneToMany(cascade=CascadeType.ALL, mappedBy="usuario")
	private List<CamisetaEntity> camisetas;
		
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

	public List<CamisetaEntity> getCamisetas() {
		return camisetas;
	}

	public void setCamisetas(List<CamisetaEntity> camisetas) {
		this.camisetas = camisetas;
	}

	
}
