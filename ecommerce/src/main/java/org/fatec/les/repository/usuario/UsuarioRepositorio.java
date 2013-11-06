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
	
	public Usuario inserirUSuario(Usuario usuario) {
		em.getTransaction().begin();
		if (usuario.getId() == null) {
			em.persist(usuario);
		} else {
			em.merge(usuario);
		}
		em.getTransaction().commit();
		return usuario;
	}
	
	public void deletar(Usuario usuario) {
		em.getTransaction().begin();
		em.remove(usuario);
		em.getTransaction().commit();
	}
	
	public Usuario buscarRegistro(Long id) {
		String jpql = "SELECT u FROM usuario u where id = " + id.toString();
		TypedQuery<Usuario> usuario = em.createQuery(jpql, Usuario.class);
		return usuario.getSingleResult();
	}
	
	public List<Usuario> listarTodos() {
		String jpql = "SELECT u FROM usuario u";
		TypedQuery<Usuario> q = em.createQuery(jpql, Usuario.class);
		return q.getResultList();
		
	}
}
