package com.algures.bean;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import com.algures.bo.AlunoBO;
import com.algures.bo.EscolaBO;
import com.algures.bo.MatriculaBO;
import com.algures.bo.SerieBO;
import com.algures.bo.TurmaBO;
import com.algures.model.Aluno;
import com.algures.model.Endereco;
import com.algures.model.Escola;
import com.algures.model.Matricula;
import com.algures.model.Serie;
import com.algures.model.Turma;

@ManagedBean
@RequestScoped
public class AlunoBean {

	private Aluno aluno;
	private Endereco endereco;
	private List<Serie> series;
	@SuppressWarnings("unused")
	private List<Escola> escolas;
	private List<Turma> turmas;
	private Matricula matricula;
	private Date data;

	private Long idTurmaSelected;

	public AlunoBean() {
		aluno = new Aluno();
		matricula = new Matricula();
		endereco = new Endereco();
	}

	public void newObject() {
		aluno = new Aluno();
		endereco = new Endereco();
		matricula = new Matricula();
		idTurmaSelected = null;
	}

	public String salvar() {

		try {
			if (!aluno.getNome().isEmpty() && !aluno.getEmailA().isEmpty()
					&& !aluno.getEmailR().isEmpty()
					&& !aluno.getNomemae().isEmpty()
					&& !aluno.getNomepai().isEmpty()
					&& !aluno.getFone().isEmpty()) {
				aluno.setEndereco(endereco);
				aluno.setSenha("2014");
				matricula.setAluno(aluno);
				MatriculaBO.salvar(matricula, idTurmaSelected);
				newObject();
				FacesMessage msg = new FacesMessage("", "Registro Salvo");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				return "../administrator/index";
			} else {
				FacesMessage msg = new FacesMessage("Campos Obrigatórios",
						" Preencha todos os campos para salvar um Aluno");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				return null;
			}
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage("Error!", "Tam...");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return null;
		}
	}

	public String editar() {
		Aluno alunoEdtado = AlunoBO.editar(aluno);
		aluno = alunoEdtado;
		return "";
	}

	public void changeValuesSerie(ValueChangeEvent event) {
		Long id = Long.valueOf(event.getNewValue().toString());
		setSeries(SerieBO.getSeriesByEscola(id));
	}

	public void changeValuesTurma(ValueChangeEvent event) {
		Long id = Long.valueOf(event.getNewValue().toString());
		setTurmas(TurmaBO.getTurmasBySerie(id));
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public List<Turma> getTurmas() {
		if (turmas == null) {
			turmas = TurmaBO.getTurmas();
		}
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<Serie> getSeries() {
		if (series == null) {
			series = SerieBO.getSeries();
		}
		return series;
	}

	public void setSeries(List<Serie> series) {
		this.series = series;
	}

	public List<Escola> getEscolas() {
		return EscolaBO.listEscola();
	}

	public void setEscolas(List<Escola> escolas) {
		this.escolas = escolas;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Long getIdTurmaSelected() {
		return idTurmaSelected;
	}

	public void setIdTurmaSelected(Long idTurmaSelected) {
		this.idTurmaSelected = idTurmaSelected;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
