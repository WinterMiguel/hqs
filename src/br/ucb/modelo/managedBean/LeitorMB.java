package br.ucb.modelo.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.ucb.modelo.Editora;
import br.ucb.modelo.Leitor;
import br.ucb.modelo.Personagem;
import br.ucb.modelo.dao.EditoraDAO;
import br.ucb.modelo.dao.LeitorDAO;
import br.ucb.modelo.dao.PersonagemDAO;

@ManagedBean(name = "leitorMB")
@SessionScoped
public class LeitorMB implements Serializable {
	private static final long serialVersionUID = 1L;
	private Leitor leitor;
	private LeitorDAO leitorDAO;
	private List<Personagem> personagens;
	private List<Editora> editoras;
	private EditoraDAO editoraDao;
	private PersonagemDAO personagemDao;
	private Personagem personagem;
	private Editora editora;

	public LeitorMB() {
		this.leitor = new Leitor();
		this.leitorDAO = new LeitorDAO();
		this.personagem = new Personagem();
		this.editora = new Editora();
		this.editoraDao = new EditoraDAO();
		this.personagemDao = new PersonagemDAO();
		this.listar();
	}

	public String salvar() {

		Leitor leitorNovo = this.leitorDAO.consultar(this.leitor.getEmail());

		if (leitorNovo == null) {
			if (this.leitorDAO.cadastrarLeitor(this.leitor)) {
				FacesContext fc = FacesContext.getCurrentInstance();
				FacesMessage fm = new FacesMessage("Leitor Cadastrado");
				fc.addMessage(null, fm);
				this.editora.contarVotos();
				this.personagem.contarVotos();
				this.leitor.setVotou(true);
			}
		} else if(leitorNovo != null && leitorNovo.getVotou()){
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage fm = new FacesMessage("Leitor Já Cadastrado");
			fc.addMessage(null, fm);
		}

		return "index";
	}

	public String cadastrarLeitor() {
		this.leitor = new Leitor();
		return "formularioLeitor";
	}

	public void listar() {
		this.personagens = personagemDao.listar();
		this.editoras = editoraDao.listar();
	}

	public Leitor getLeitor() {
		return leitor;
	}

	public void setLeitor(Leitor leitor) {
		this.leitor = leitor;
	}

	public LeitorDAO getLeitorDAO() {
		return leitorDAO;
	}

	public void setLeitorDAO(LeitorDAO leitorDAO) {
		this.leitorDAO = leitorDAO;
	}

	public List<Personagem> getPersonagens() {
		return personagens;
	}

	public void setPersonagens(List<Personagem> personagens) {
		this.personagens = personagens;
	}

	public List<Editora> getEditoras() {

		return editoras;
	}

	public void setEditoras(List<Editora> editoras) {
		this.editoras = editoras;
	}

	public EditoraDAO getEditoraDao() {
		return editoraDao;
	}

	public void setEditoraDao(EditoraDAO editoraDao) {
		this.editoraDao = editoraDao;
	}

	public PersonagemDAO getPersonagemDao() {
		return personagemDao;
	}

	public void setPersonagemDao(PersonagemDAO personagemDao) {
		this.personagemDao = personagemDao;
	}

	public Personagem getPersonagem() {
		return personagem;
	}

	public void setPersonagem(Personagem personagem) {
		this.personagem = personagem;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

}
