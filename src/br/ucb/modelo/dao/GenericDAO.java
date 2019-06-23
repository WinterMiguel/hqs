package br.ucb.modelo.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class GenericDAO<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	private Class classe;
	private EntityManager entityManager;
	
	@SuppressWarnings("rawtypes")
	public GenericDAO() {
		this.classe = (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.entityManager = ConnectionFactory.getEntityManager();
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public boolean cadastrarLeitor(T objeto) {
		this.entityManager.getTransaction().begin();
		try {
			this.entityManager.persist(objeto);
			this.entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean votar(T objeto) {
		this.entityManager.getTransaction().begin();
		try {
			this.entityManager.merge(objeto);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<T> listar() {
		Query q = this.entityManager.createQuery("SELECT c FROM "+
				this.classe.getName() +" c");
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public T consultar(long id) {
		return (T) this.entityManager.find(this.classe, id);
	}
}
