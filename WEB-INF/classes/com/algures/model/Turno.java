package com.algures.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the turnos database table.
 * 
 */
@Entity
@Table(name = "turnos")
@NamedQueries({
		@NamedQuery(name = "Turno.findAll", query = "SELECT t FROM Turno t"),
		@NamedQuery(name = "Turno.findById", query = "SELECT t FROM Turno t WHERE t.turnoid =:turnoid") })
public class Turno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long turnoid;

	private String obs;

	private String turno;

	public Turno() {
	}

	public Long getTurnoid() {
		return this.turnoid;
	}

	public void setTurnoid(Long turnoid) {
		this.turnoid = turnoid;
	}

	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getTurno() {
		return this.turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	@Override
	public String toString() {
		return "Turno [turnoid=" + turnoid + ", obs=" + obs + ", turno="
				+ turno + "]";
	}

}