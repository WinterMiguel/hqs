package br.ucb.modelo.dao;

import br.ucb.modelo.Leitor;

public class LeitorDAO extends GenericDAO<Leitor> {
	private static final long serialVersionUID = 1L;
	 
	
	public Leitor consultar(String email) {
		// TODO Auto-generated method stub
		return super.getEntityManager().find(Leitor.class, email);
	}

}
