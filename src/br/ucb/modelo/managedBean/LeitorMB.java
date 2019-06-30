package br.ucb.modelo.managedBean;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

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

	private static AtomicLong at = new AtomicLong();

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
			if (this.leitorDAO.incluir(this.leitor)) {
				FacesContext fc = FacesContext.getCurrentInstance();
				FacesMessage fm = new FacesMessage("Leitor Cadastrado");
				fc.addMessage(null, fm);
			}
		} else if (leitorNovo != null) {
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage fm = new FacesMessage("Leitor: " + this.leitor.getEmail() + " já cadastrado. Falta votar!");
			fc.addMessage(null, fm);
		}

		return "index";

	}

	public String votar() {
		Leitor leitorNovo = this.leitorDAO.consultar(this.leitor.getEmail());

		if (leitorNovo == null) {
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage fm = new FacesMessage("Leitor não cadastrado");
			fc.addMessage(null, fm);
			return "formularioLeitor?faces-redirect=true";
		}

		if (leitorNovo != null) {
			if (leitorNovo.getVotou()) {
				FacesContext fc = FacesContext.getCurrentInstance();
				FacesMessage fm = new FacesMessage("Leitor: " + this.leitor.getEmail() + " já Votou");
				fc.addMessage(null, fm);
				return "index?faces-redirect=true";
			} else {
				this.personagem.setVotos(verificarProximoValorPersonagem());
				this.editora.setVotos(verficarProximoValorEditora() - 1);
				this.leitor.setVotou(true);
				this.personagemDao.alterar(this.personagem);
				this.editoraDao.alterar(this.editora);
				this.leitorDAO.alterar(this.leitor);
				FacesContext fc = FacesContext.getCurrentInstance();
				FacesMessage fm = new FacesMessage("Voto computado com sucesso!!");
				fc.addMessage(null, fm);
			}
		}
		
		return "index?faces-redirect=true";
	}

	public String cadastrarLeitor() {
		this.leitor = new Leitor();
		return "formularioLeitor?faces-redirect=true";
	}

	public void listar() {
		this.personagens = personagemDao.listar();
		this.editoras = editoraDao.listar();
	}

	private Long verificarProximoValorPersonagem() {
		this.personagemDao.consultar(this.personagem.getId()).getVotos();
		return at.incrementAndGet();
	}

	private Long verficarProximoValorEditora() {
		this.editoraDao.consultar(this.editora.getId()).getVotos();
		return at.incrementAndGet();
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
