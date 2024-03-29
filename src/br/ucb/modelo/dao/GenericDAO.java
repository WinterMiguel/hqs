package br.ucb.modelo.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public abstract class GenericDAO<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	private Class classe;
	private EntityManager em;

	@SuppressWarnings("rawtypes")
	public GenericDAO() {
		this.classe = (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.em = ConnectionFactory.getEntityManager();
	}

	public boolean incluir(T objeto) {
		this.em.getTransaction().begin();
		try {
			this.em.persist(objeto);
			this.em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean alterar(T objeto) {
		this.em.getTransaction().begin();
		try {
			this.em.merge(objeto);
			this.em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public T consultar(long id) {
		return (T) this.em.find(this.classe, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> listar() {
		Query q = this.em.createQuery("SELECT c FROM "+
				this.classe.getName() +" c");
		return q.getResultList();
	}

	public EntityManager getEm() {
		return em;
	}

}
