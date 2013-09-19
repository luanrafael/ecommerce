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
}
