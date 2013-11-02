package org.fatec.les.service.usuario;

import java.util.List;

import org.fatec.les.model.usuario.Usuario;
import org.fatec.les.repository.usuario.UsuarioRepositorio;

public class UsuarioService {

	private UsuarioRepositorio repositorio;
	
	public void inserirUsuario(Usuario usuario) {
		repositorio.inserirUSuario(usuario);
	}
	
	public void deletar(Usuario usuario) {
		repositorio.deletar(usuario);
	}
	
	public Usuario buscarUsuario(Long id) {
		Usuario usuario = repositorio.buscarUsuario(id);
		return usuario;
	}
	
	public List<Usuario> buscarTodos() {
		List<Usuario> usuarios = repositorio.listarTodos();
		return usuarios;
	}
	
}
