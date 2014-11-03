package com.algures.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.algures.bo.SerieBO;
import com.algures.bo.TurmaBO;
import com.algures.bo.TurnoBo;
import com.algures.model.Serie;
import com.algures.model.Turma;
import com.algures.model.Turno;

@ManagedBean
@RequestScoped
public class TurmaBean {

	private Turma turma;
	private List<Serie> series;
	private Long idSerieSelecionada;
	private Long idTurnoSelecionado;
	private List<Turno> turnos;

	public TurmaBean() {
		turma = new Turma();
	}

	public void newObject() {
		turma = new Turma();
		idSerieSelecionada = null;
		idTurnoSelecionado = null;
		series = null;
	}

	public String salvar() {
		try {
			if (!turma.getTurma().isEmpty()
					&& !turma.getNumalunosmax().isEmpty()
					&& !turma.getNumsala().isEmpty()
					&& !String.valueOf(idSerieSelecionada).isEmpty()
					&& !String.valueOf(idTurnoSelecionado).isEmpty()) {

				TurmaBO.salvar(turma, idSerieSelecionada, idTurnoSelecionado);
				newObject();
				FacesMessage msg = new FacesMessage("", "Registro Salvo");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				return "administrator/index.jsf";
			} else {
				FacesMessage msg = new FacesMessage("Campo Obrigatório", "Preencha todos os campos obrigatórios!");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				return "";
			}
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage("ERROR", "Ocorreu um erro inesperado, entre novamente com o registro!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return null;
		}

	}

	public String retornaMenu() {

		return "administrator/index.jsf";
	}

	public List<Serie> getSeries() {
		series = SerieBO.getSeries();
		return series;
	}

	public void setSeries(List<Serie> series) {
		this.series = series;
	}

	public List<Turno> getTurnos() {
		turnos = TurnoBo.getTurnos();
		return turnos;
	}

	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Long getIdSerieSelecionada() {
		return idSerieSelecionada;
	}

	public void setIdSerieSelecionada(Long idSerieSelecionada) {
		this.idSerieSelecionada = idSerieSelecionada;
	}

	public Long getIdTurnoSelecionado() {
		return idTurnoSelecionado;
	}

	public void setIdTurnoSelecionado(Long idTurnoSelecionado) {
		this.idTurnoSelecionado = idTurnoSelecionado;
	}

}
