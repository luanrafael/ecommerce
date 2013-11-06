package org.fatec.les.service;

import java.util.List;

import org.fatec.les.model.entity.UsuarioEntity;
import org.fatec.les.repositorio.UsuarioRepositorio;

public class UsuarioService {

	private UsuarioRepositorio repositorio;
	
	public void inserirUsuario(UsuarioEntity usuario) {
		repositorio.persist(usuario);
	}
	
	public void deletar(UsuarioEntity usuario) {
		repositorio.deleteById(usuario.getId());
	}
	
	public UsuarioEntity buscarUsuario(Long id) {
		UsuarioEntity usuario = repositorio.load(id);
		return usuario;
	}
	
	
	public List<UsuarioEntity> buscarTodos() {
		List<UsuarioEntity> usuarios = repositorio.loadAll();
		return usuarios;
	}
	
	
	
}
