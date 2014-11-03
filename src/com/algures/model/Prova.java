package com.algures.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;


/**
 * The persistent class for the provas database table.
 * 
 */
@Entity
@Table(name="provas")

@NamedQueries({
	@NamedQuery(name="Prova.findAll", query="SELECT p FROM Prova p"),
	@NamedQuery(name = "Prova.mediaEscola", query = "SELECT avg(p.nota) FROM Prova p")})

public class Prova implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long provaid;

	private String bimestre;

	private String descricao;
    @Column(precision=2,scale=2)
	private BigDecimal nota;

	@ManyToOne
	@JoinColumn(name="DISCIPLINAID",referencedColumnName = "DISCIPLINAID")
	private Disciplina disciplina;

	@ManyToOne
	@JoinColumn(name="MATRICULAID",referencedColumnName = "MATRICULAID")
	private Matricula matricula;

	public Prova() {
	}

	public Long getProvaid() {
		return this.provaid;
	}

	public void setProvaid(Long provaid) {
		this.provaid = provaid;
	}

	public String getBimestre() {
		return this.bimestre;
	}

	public void setBimestre(String bimestre) {
		this.bimestre = bimestre;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getNota() {
		return this.nota;
	}

	public void setNota(BigDecimal nota) {
		this.nota = nota;
	}

	public Disciplina getDisciplina() {
		return this.disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Matricula getMatricula() {
		return this.matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Prova [provaid=" + provaid + ", bimestre=" + bimestre
				+ ", descricao=" + descricao + ", nota=" + nota
				+ ", disciplina=" + disciplina + ", matricula=" + matricula
				+ "]";
	}
	
	

}