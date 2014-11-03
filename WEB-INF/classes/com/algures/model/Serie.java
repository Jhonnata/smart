package com.algures.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the series database table.
 * 
 */
@Entity
@Table(name="series")
@NamedQueries({
	@NamedQuery(name="Serie.findAll", query="SELECT s FROM Serie s"),
	@NamedQuery(name = "Serie.findById", query = "SELECT s FROM Serie s WHERE s.serieid =:serieid"),
	@NamedQuery(name = "Serie.findSerieEscola", query = "SELECT s FROM Serie s WHERE s.escola.escolaid =:escolaid") })
public class Serie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long serieid;

	private String ano;

	private String nome;

	@ManyToOne
	@JoinColumn(name="ESCOLAID")
	private Escola escola;

	@OneToMany(mappedBy="sery")
	private List<Turma> turmas;
	public Serie() {
	}

	public Long getSerieid() {
		return this.serieid;
	}

	public void setSerieid(Long serieid) {
		this.serieid = serieid;
	}

	public String getAno() {
		return this.ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Escola getEscola() {
		return this.escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}

	public List<Turma> getTurmas() {
		return this.turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public Turma addTurma(Turma turma) {
		getTurmas().add(turma);
		turma.setSery(this);

		return turma;
	}

	public Turma removeTurma(Turma turma) {
		getTurmas().remove(turma);
		turma.setSery(null);

		return turma;
	}

	@Override
	public String toString() {
		return "Serie [serieid=" + serieid + ", ano=" + ano + ", nome=" + nome
				+ ", escola=" + escola + ", turmas=" + turmas + "]";
	}
	

}