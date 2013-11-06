package org.fatec.les.service;

import java.util.List;

import org.fatec.les.model.usuario.Usuario;
import org.fatec.les.repository.usuario.UsuarioRepositorio;

public class UsuarioServico {

	private UsuarioRepositorio repositorio;
	
	public Usuario inserirUsuario(Usuario usuario) {
		return this.repositorio.inserirUSuario(usuario);
	}
	
	public Usuario excluir(Long id) {
		Usuario usuario = buscarRegistro(id);
		this.repositorio.deletar(usuario);
		return usuario;
	}
	
	public Usuario buscarRegistro(Long id) {
		return this.repositorio.buscarRegistro(id);
	}
	
	public List<Usuario> listarTodos() {
		return this.repositorio.listarTodos();
	}
	
}
