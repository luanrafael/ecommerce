package org.fatec.les.model.usuario;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Cliente {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	@OneToOne
	private Endereco endereco;
	
	public void setEndereco(Endereco endereco){
		this.endereco = endereco;
	}
	
	public Endereco getEndereco(){
		return endereco;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
