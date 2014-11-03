package com.algures.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.algures.bo.ProfessorBO;
import com.algures.model.Professor;

@ManagedBean
@ViewScoped
public class ProfessorListaBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Professor professor;
	private List<Professor> professores;

	public ProfessorListaBean() {

	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Professor> getProfessores() {
		if (professores == null) {
			professores = ProfessorBO.listarProfessor();
		}
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

}
