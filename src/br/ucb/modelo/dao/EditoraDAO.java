package br.ucb.modelo.dao;

import java.util.List;

import javax.persistence.Query;

import br.ucb.modelo.Editora;

public class EditoraDAO extends GenericDAO<Editora> {
	private static final long serialVersionUID = 1L;

	@Override
	public List<Editora> listar() {
		Query q = super.getEntityManager().createQuery("SELECT c FROM editora c ORDER BY c.votos DESC");
		return q.getResultList();
	}

}
