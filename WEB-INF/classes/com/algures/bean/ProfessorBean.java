package com.algures.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.algures.bo.DisciplinaBO;
import com.algures.bo.ProfessorBO;
import com.algures.model.Disciplina;
import com.algures.model.Endereco;
import com.algures.model.Professor;

@ManagedBean
@RequestScoped
public class ProfessorBean {

	private Professor professor;
	private Endereco endereco;

	private List<Disciplina> disciplinas;
	private Long idDisciplinaSelecionada;

	public ProfessorBean() {
		professor = new Professor();
		endereco = new Endereco();
	}

	public void newObject() {
		professor = new Professor();
		endereco = new Endereco();
		idDisciplinaSelecionada = null;
		disciplinas = null;
	}

	public String salvar() {

		try {
			if (!professor.getNome().isEmpty() && !professor.getCpf().isEmpty()
					&& !professor.getDisciplina().getNome().isEmpty()
					&& !professor.getEndereco().getRua().isEmpty()) {
				ProfessorBO
						.salvar(professor, endereco, idDisciplinaSelecionada);
				newObject();
				FacesMessage msg = new FacesMessage("", "Registro Salvo");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				return "../administrator/index.jsf";
			} else {
				FacesMessage msg = new FacesMessage("Campos Obrigatórios!", "Preencha todos os campos obrigatórios");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				return "";
			}
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage("Error!","Tam...");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return null;
		}
	}

	public Long getIdDisciplinaSelecionada() {
		return idDisciplinaSelecionada;
	}

	public void setIdDisciplinaSelecionada(Long idDisciplinaSelecionada) {
		this.idDisciplinaSelecionada = idDisciplinaSelecionada;
	}

	public List<Disciplina> getDisciplinas() {
		disciplinas = DisciplinaBO.listDisciplina();
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
