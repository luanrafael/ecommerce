package org.fatec.les.repository.usuario;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.fatec.les.model.usuario.Usuario;

<<<<<<< HEAD

public class UsuarioRepositorio {

=======

public class UsuarioRepositorio {
	
>>>>>>> b7e9751fe21d3292650cc329a09b531459f2de50
	private EntityManager em;

	public UsuarioRepositorio() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ecommerce");
		em = emf.createEntityManager();
	}
	
<<<<<<< HEAD
	public Usuario inserirUSuario(Usuario usuario) {
=======
	public void inserirUSuario(Usuario usuario) {
>>>>>>> b7e9751fe21d3292650cc329a09b531459f2de50
		em.getTransaction().begin();
		if (usuario.getId() == null) {
			em.persist(usuario);
		} else {
			em.merge(usuario);
		}
		em.getTransaction().commit();
<<<<<<< HEAD
		return usuario;
=======
>>>>>>> b7e9751fe21d3292650cc329a09b531459f2de50
	}
	
	public void deletar(Usuario usuario) {
		em.getTransaction().begin();
		em.remove(usuario);
		em.getTransaction().commit();
	}
	
<<<<<<< HEAD
	public Usuario buscarRegistro(Long id) {
		String jpql = "SELECT u FROM usuario u where id = " + id.toString();
=======
	public Usuario buscarUsuario(Long id) {
		String jpql = "SELECT c FROM Usuario c where id = " + id.toString();
>>>>>>> b7e9751fe21d3292650cc329a09b531459f2de50
		TypedQuery<Usuario> usuario = em.createQuery(jpql, Usuario.class);
		return usuario.getSingleResult();
	}
	
	public List<Usuario> listarTodos() {
<<<<<<< HEAD
		String jpql = "SELECT u FROM usuario u";
		TypedQuery<Usuario> q = em.createQuery(jpql, Usuario.class);
		return q.getResultList();
		
=======
		String jpql = "SELECT c FROM Usuario c";
		TypedQuery<Usuario> usuarios = em.createQuery(jpql, Usuario.class);
		return usuarios.getResultList();
>>>>>>> b7e9751fe21d3292650cc329a09b531459f2de50
	}
}
