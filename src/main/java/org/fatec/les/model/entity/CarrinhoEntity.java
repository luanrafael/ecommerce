package org.fatec.les.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CarrinhoEntity {

	@Id
	@GeneratedValue
	private Long id;
	
	private List<CamisetaEntity> camisetas;
	
	private UsuarioEntity usuario;
	
	
}
