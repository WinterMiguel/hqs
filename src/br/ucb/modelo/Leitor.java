package br.ucb.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.ucb.modelo.managedBean.LeitorMB;

@Entity
public class Leitor implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String email;
	private String nome;
	private boolean votou;
	@OneToMany(mappedBy="leitor")
	private java.util.List<Personagem> personagens;
	
	public Leitor() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean getVotou() {
		return votou;
	}

	public void setVotou(boolean votou) {
		this.votou = votou;
	}
	
}
