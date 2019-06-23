package br.ucb.modelo.dao;

import java.util.List;

import javax.persistence.Query;

import br.ucb.modelo.Personagem;

public class PersonagemDAO extends GenericDAO<Personagem> {
	private static final long serialVersionUID = 1L;

	@Override
	public List<Personagem> listar() {
		Query q = super.getEntityManager().createQuery("SELECT c FROM comic c ORDER BY c.votos DESC");
		return q.getResultList();
	}
	
}
