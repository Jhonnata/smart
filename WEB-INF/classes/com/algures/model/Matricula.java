package com.algures.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


/**
 * The persistent class for the matricula database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Matricula.findAll", query="SELECT m FROM Matricula m"),
	@NamedQuery(name = "Matricula.findById", query = "SELECT s FROM Matricula s WHERE s.matriculaid =:matriculaid"),
	@NamedQuery(name = "Matricula.listByTurma", query = "SELECT s FROM Matricula s WHERE s.turma.turmaid =:turmaid"),
	@NamedQuery ( name = "Matricula.count" , query = " SELECT COUNT (s) FROM Matricula s " )})
public class Matricula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long matriculaid;

	@Temporal(TemporalType.DATE)
	private Date anoletivo;

	private String obs;

	@OneToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name="RA",referencedColumnName = "RA")
	private Aluno aluno;

	@ManyToOne
	@JoinColumn(name="TURMAID",referencedColumnName = "TURMAID")
	private Turma turma;

	public Matricula() {
	}

	public Long getMatriculaid() {
		return this.matriculaid;
	}

	public void setMatriculaid(Long matriculaid) {
		this.matriculaid = matriculaid;
	}

	public Date getAnoletivo() {
		return this.anoletivo;
	}

	public void setAnoletivo(Date anoletivo) {
		this.anoletivo = anoletivo;
	}

	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Turma getTurma() {
		return this.turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	@Override
	public String toString() {
		return "Matricula [matriculaid=" + matriculaid + ", anoletivo="
				+ anoletivo + ", obs=" + obs + ", aluno=" + aluno + ", turma="
				+ turma + "]";
	}
	
	

}