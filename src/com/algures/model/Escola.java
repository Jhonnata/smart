package com.algures.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the escola database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Escola.findAll", query = "SELECT e FROM Escola e"),
	@NamedQuery(name = "Escola.findById", query = "SELECT e FROM Escola e WHERE e.escolaid =:escolaid") })
public class Escola implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long escolaid;

	private String codigo;

	private String nome;

	@OneToOne
	@JoinColumn(name="ENDERECOID")
	private Endereco endereco;

	@OneToMany(mappedBy="escola")
	private List<Serie> series;

	public Escola() {
	}

	public Long getEscolaid() {
		return this.escolaid;
	}

	public void setEscolaid(Long escolaid) {
		this.escolaid = escolaid;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Serie> getSeries() {
		return this.series;
	}

	public void setSeries(List<Serie> series) {
		this.series = series;
	}

	public Serie addSery(Serie sery) {
		getSeries().add(sery);
		sery.setEscola(this);

		return sery;
	}

	public Serie removeSery(Serie sery) {
		getSeries().remove(sery);
		sery.setEscola(null);

		return sery;
	}

	@Override
	public String toString() {
		return "Escola [escolaid=" + escolaid + ", codigo=" + codigo
				+ ", nome=" + nome + ", endereco=" + endereco + ", series="
				+ series + "]";
	}
	

}