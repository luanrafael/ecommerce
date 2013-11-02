package org.fatec.les.repository.usuario;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.fatec.les.model.usuario.Usuario;


public class UsuarioRepositorio {
	
	private EntityManager em;

	public UsuarioRepositorio() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ecommerce");
		em = emf.createEntityManager();
	}
	
	public void inserirUSuario(Usuario usuario) {
		em.getTransaction().begin();
		if (usuario.getId() == null) {
			em.persist(usuario);
		} else {
			em.merge(usuario);
		}
		em.getTransaction().commit();
	}
	
	public void deletar(Usuario usuario) {
		em.getTransaction().begin();
		em.remove(usuario);
		em.getTransaction().commit();
	}
	
	public Usuario buscarUsuario(Long id) {
		String jpql = "SELECT c FROM Usuario c where id = " + id.toString();
		TypedQuery<Usuario> usuario = em.createQuery(jpql, Usuario.class);
		return usuario.getSingleResult();
	}
	
	public List<Usuario> listarTodos() {
		String jpql = "SELECT c FROM Usuario c";
		TypedQuery<Usuario> usuarios = em.createQuery(jpql, Usuario.class);
		return usuarios.getResultList();
	}
}
