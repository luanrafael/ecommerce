package org.fatec.les.service;

import java.util.List;

import org.fatec.les.model.entity.CamisetaEntity;
import org.fatec.les.repositorio.CamisetaRepositorio;

public class CamisetaService {
	
private CamisetaRepositorio repositorio;
	
	public void inserirCamiseta(CamisetaEntity camiseta) {
		repositorio.persist(camiseta);
	}
	
	public void deletarCamiseta(CamisetaEntity camiseta) {
		repositorio.deleteById(camiseta.getIdCamiseta());
	}
	
	public CamisetaEntity buscarPorId(Long id) {
		CamisetaEntity camiseta = repositorio.load(id);
		return camiseta;
	}
	
	public List<CamisetaEntity> buscarPorTime(CamisetaEntity camiseta) {
		List<CamisetaEntity> camisetas = repositorio.buscarPorTime(camiseta.getTime());
		return camisetas;
	}
	
	public List<CamisetaEntity> buscarPorPreco(CamisetaEntity camiseta) {
		List<CamisetaEntity> camisetas = repositorio.buscarPorPreco(camiseta.getPreco());
		return camisetas;
	}
		
	public List<CamisetaEntity> buscarTodasCamisetas() {
		List<CamisetaEntity> camisetas = repositorio.loadAll();
		return camisetas;
	}
	
	public CamisetaEntity editarCamiseta(CamisetaEntity camiseta){
		CamisetaEntity camisetaEditada= repositorio.merge(camiseta);
		return camisetaEditada;
	}
	
	
	
}
