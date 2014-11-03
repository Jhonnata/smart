package com.algures.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the disciplinas database table.
 * 
 */
@Entity
@Table(name="disciplinas")
@NamedQueries({
	@NamedQuery(name = "Disciplina.findAll", query = "SELECT d FROM Disciplina d"),
	@NamedQuery(name = "Disciplina.findById", query = "SELECT d FROM Disciplina d WHERE d.disciplinaid =:disciplinaid") })
public class Disciplina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long disciplinaid;

	private String descricao;

	private String nome;

	@OneToMany(mappedBy="disciplina")
	private List<Professor> professores;

	@OneToMany(mappedBy="disciplina")
	private List<Prova> provas;

	public Disciplina() {
	}

	public Long getDisciplinaid() {
		return this.disciplinaid;
	}

	public void setDisciplinaid(Long disciplinaid) {
		this.disciplinaid = disciplinaid;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Professor> getProfessores() {
		return this.professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public Professor addProfessore(Professor professore) {
		getProfessores().add(professore);
		professore.setDisciplina(this);

		return professore;
	}

	public Professor removeProfessore(Professor professore) {
		getProfessores().remove(professore);
		professore.setDisciplina(null);

		return professore;
	}

	public List<Prova> getProvas() {
		return this.provas;
	}

	public void setProvas(List<Prova> provas) {
		this.provas = provas;
	}

	public Prova addProva(Prova prova) {
		getProvas().add(prova);
		prova.setDisciplina(this);

		return prova;
	}

	public Prova removeProva(Prova prova) {
		getProvas().remove(prova);
		prova.setDisciplina(null);

		return prova;
	}

	@Override
	public String toString() {
		return "Disciplina [disciplinaid=" + disciplinaid + ", descricao="
				+ descricao + ", nome=" + nome + ", professores=" + professores
				+ ", provas=" + provas + "]";
	}

}