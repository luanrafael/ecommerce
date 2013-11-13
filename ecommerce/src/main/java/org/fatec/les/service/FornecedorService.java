package org.fatec.les.service;

import java.util.List;

import org.fatec.les.model.entity.FornecedorEntity;
import org.fatec.les.repositorio.FornecedorRepositorio;

public class FornecedorService {

private FornecedorRepositorio repositorio;
	
	public void inserirFornecedor(FornecedorEntity fornecedore) {
		repositorio.persist(fornecedore);
	}
	
	public void deletar(FornecedorEntity fornecedore) {
		repositorio.deleteById(fornecedore.getId());
	}
	
	public FornecedorEntity buscarFornecedor(Long id) {
		FornecedorEntity Fornecedor = repositorio.load(id);
		return Fornecedor;
	}
	
	public List<FornecedorEntity> buscarTodos() {
		List<FornecedorEntity> fornecedores = repositorio.loadAll();
		return fornecedores;
	}
	
}
