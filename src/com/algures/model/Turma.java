package com.algures.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the turmas database table.
 * 
 */
@Entity
@Table(name="turmas")

@NamedQueries({
	@NamedQuery(name="Turma.findAll", query="SELECT t FROM Turma t"),
	@NamedQuery(name = "Turma.findById", query = "SELECT t FROM Turma t WHERE t.turmaid =:turmaid"),
	@NamedQuery(name = "Turma.listBySerie", query = "SELECT t FROM Turma t WHERE t.sery.serieid =:serieid") })

public class Turma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long turmaid;

	private String numalunosmax;

	private String numsala;

	private String obs;

	private String turma;

	@ManyToOne
	@JoinColumn(name="SERIEID")
	private Serie sery;

	@ManyToOne
	@JoinColumn(name="TURNOID")
	private Turno turno;

	public Turma() {
	}

	public Long getTurmaid() {
		return this.turmaid;
	}

	public void setTurmaid(Long turmaid) {
		this.turmaid = turmaid;
	}

	public String getNumalunosmax() {
		return this.numalunosmax;
	}

	public void setNumalunosmax(String numalunosmax) {
		this.numalunosmax = numalunosmax;
	}

	public String getNumsala() {
		return this.numsala;
	}

	public void setNumsala(String numsala) {
		this.numsala = numsala;
	}

	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getTurma() {
		return this.turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}
	public Serie getSery() {
		return this.sery;
	}

	public void setSery(Serie sery) {
		this.sery = sery;
	}

	public Turno getTurno() {
		return this.turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	@Override
	public String toString() {
		return "Turma [turmaid=" + turmaid + ", numalunosmax=" + numalunosmax
				+ ", numsala=" + numsala + ", obs=" + obs + ", turma=" + turma
				+ ", sery=" + sery + ", turno=" + turno + "]";
	}
	
	

}