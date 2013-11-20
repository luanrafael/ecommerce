package org.fatec.les.repositorio;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

@SuppressWarnings("unchecked")
public abstract class BaseRepositorio<T> {
	@PersistenceContext
	protected EntityManager entityManager;
	protected EntityManagerFactory entityManagerFactory;
	
	public BaseRepositorio(){
	
		entityManagerFactory = Persistence.createEntityManagerFactory("ecommerce");
		entityManager = entityManagerFactory.createEntityManager();
		
	}
	
	private Class<T> getTypeClass() {
		return (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public T load(Object id) {
		return entityManager.find(getTypeClass(), id);
	}

	public List<T> loadAll() {
		String sql = "select c from " + getTypeClass().getSimpleName() + " c ";
		return entityManager.createQuery(sql).getResultList();
	}

	public void persist(T entity) {
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
	}

	public T merge(T entity) {
		entityManager.getTransaction().begin();
		T retorno = (T)entityManager.merge(entity);
		entityManager.getTransaction().commit();
		return retorno;
		
	}

	public void remove(T entity) {
		entityManager.getTransaction().begin();
		entityManager.remove(entity);
		entityManager.getTransaction().commit();
	}
	
	public void deleteById(Object entityId) {
		T entity = load(entityId);
		remove(entity);
	}

}
