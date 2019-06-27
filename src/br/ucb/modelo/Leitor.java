package br.ucb.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="leitor")
public class Leitor implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String email;
	private String nome;
	private boolean votou;

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
