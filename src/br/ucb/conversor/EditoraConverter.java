package br.ucb.conversor;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.ucb.modelo.dao.EditoraDAO;
import br.ucb.modelo.Editora;

@FacesConverter(value="personagemConverter")
public class EditoraConverter implements Converter, Serializable {
	private static final long serialVersionUID = 1L;

	public String getAsString(FacesContext arg0, UIComponent arg1, Object editora) {
		System.out.println("--> getAsString = "+ ((Editora)editora).getId() +" - "+ ((Editora)editora).getNome());
		return String.valueOf(((Editora)editora).getId());
	}

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String editora) {
		System.out.println("--> getAsObject = "+ editora);
		return (new EditoraDAO()).consultar(Long.parseLong(editora));
	}
}
