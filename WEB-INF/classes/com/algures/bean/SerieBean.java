package com.algures.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.algures.bo.EscolaBO;
import com.algures.bo.SerieBO;
import com.algures.bo.TurnoBo;
import com.algures.model.Escola;
import com.algures.model.Serie;
import com.algures.model.Turno;

@ManagedBean
@RequestScoped
public class SerieBean {

	private Serie serie;
	private List<Escola> escolas;
	private Long idEscolaSelecionada;
	private Long idTurnoSelecionado;
	private List<Turno> turnos;

	public SerieBean() {

		serie = new Serie();
	}

	public void newObject() {
		serie = new Serie();
		idEscolaSelecionada = null;
		escolas = null;
	}

	public Long getIdEscolaSelecionada() {
		return idEscolaSelecionada;
	}

	public void setIdEscolaSelecionada(Long idEscolaSelecionada) {
		this.idEscolaSelecionada = idEscolaSelecionada;
	}

	public String salvar() {
		try {
			if (!serie.getNome().isEmpty()
					&& !String.valueOf(idEscolaSelecionada).isEmpty()) {

				SerieBO.salvar(serie, idEscolaSelecionada, idTurnoSelecionado);
				newObject();
				FacesMessage msg = new FacesMessage("", "Registro Salvo");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				return "../index";
			} else {
				FacesMessage msg = new FacesMessage("Campo Obrigatório",
						"Preencha todos os campos obrigatórios!");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				return "";
			}
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage("ERROR",
					"Ocorreu um erro inesperado, entre novamente com o registro!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return null;
		}

	}

	public List<Escola> getEscolas() {
		escolas = EscolaBO.listEscola();
		return escolas;
	}

	public void setEscolas(List<Escola> escolas) {
		this.escolas = escolas;
	}

	public Long getIdTurnoSelecionado() {
		return idTurnoSelecionado;
	}

	public void setIdTurnoSelecionado(Long idTurnoSelecionado) {
		this.idTurnoSelecionado = idTurnoSelecionado;
	}

	public List<Turno> getTurnos() {
		turnos = TurnoBo.getTurnos();
		return turnos;
	}

	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}
}
