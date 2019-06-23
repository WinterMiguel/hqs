package br.ucb.conversor;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.ucb.modelo.Personagem;


import br.ucb.modelo.dao.PersonagemDAO;

@FacesConverter(value="personagemConverter")
public class PersonagemConverter implements Converter, Serializable {
	private static final long serialVersionUID = 1L;

	public String getAsString(FacesContext arg0, UIComponent arg1, Object personagem) {
		System.out.println("--> getAsString = "+ ((Personagem)personagem).getId() +" - "+ ((Personagem)personagem).getNome());
		return String.valueOf(((Personagem)personagem).getId());
	}

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String idPersonagem) {
		System.out.println("--> getAsObject = "+ idPersonagem);
		return (new PersonagemDAO()).consultar(Long.parseLong(idPersonagem));
	}
}
