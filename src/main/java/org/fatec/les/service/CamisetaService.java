package org.fatec.les.service;

import java.util.List;

import org.fatec.les.model.entity.CamisetaEntity;

import org.fatec.les.repositorio.CamisetaRepositorio;


public class CamisetaService {
	
	private CamisetaRepositorio repositorio;
	
	public void inserirCamiseta(CamisetaEntity camiseta){
		repositorio.persist(camiseta);
	}
	
	public void deletarCamiseta(CamisetaEntity camiseta){
		repositorio.deleteById(camiseta.getIdCamiseta());
	}
	
	public CamisetaEntity buscarCamiseta(Long id) {
		CamisetaEntity camiseta = repositorio.load(id);
		return camiseta;
	}
	
	public List<CamisetaEntity> buscarTodos() {
		List<CamisetaEntity> camisetas = repositorio.loadAll();
		return camisetas;
	}
	
}