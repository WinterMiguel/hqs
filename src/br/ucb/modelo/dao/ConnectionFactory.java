package br.ucb.modelo.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory implements Serializable {
	private static final long serialVersionUID = 1L;
	private static EntityManagerFactory emF = null;
	private static EntityManager em = null;
	public static EntityManager getEntityManager() {
		try {
			if (emF == null)
				emF = Persistence.createEntityManagerFactory("ucomics");
		} catch (Exception e){
			System.out.println("Erro na cria��o do EntityManagerFactory"+ e);
		}
		try {
			if (em == null)
				em = emF.createEntityManager();
		} catch (Exception e){
			System.out.println("Erro na cria��o do EntityManager"+ e);
		}
		return em;
	}
}