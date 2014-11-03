package com.algures.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.algures.bo.NoticiaBO;
import com.algures.model.Noticia;

@ManagedBean
@ViewScoped
public class EventoBean {

	private Noticia noticia;
	private List<Noticia> noticias;

	public EventoBean() {
		noticia = new Noticia();
	}

	public String salvar() {
		try {
			if (!noticia.getTitulo().isEmpty()
					&& !noticia.getData().toString().isEmpty()
					&& !noticia.getTexto().isEmpty()) {

				NoticiaBO.salvar(noticia);
				novo();
				FacesMessage msg = new FacesMessage("", "Registro Salvo");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				return "..administrator/index.jsf";
			} else {
				FacesMessage msg = new FacesMessage("Campos Obrigatórios.", "Preencha todos os campos obrigatórios.");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				return "";
			}

		} catch (Exception e) {
			return null;
		}
	}

	public String novo() {
		this.noticia = new Noticia();
		return "aluno?faces-redirect=true";
	}

	public Noticia getNoticia() {
		return noticia;
	}

	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}

	public List<Noticia> getNoticias() {
		noticias = NoticiaBO.getNoticias();
		return noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}

}
