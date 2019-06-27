package br.ucb.modelo.dao;

import java.util.List;

import javax.persistence.Query;

import br.ucb.modelo.Editora;

public class EditoraDAO extends GenericDAO<Editora> {
	private static final long serialVersionUID = 1L;

	@Override
	public List<Editora> listar() {
		Query q = super.getEm().createQuery("SELECT e FROM editora e ORDER BY e.votos DESC");
		return q.getResultList();
	}

}
