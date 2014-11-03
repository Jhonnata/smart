package com.algures.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the informativos database table.
 * 
 */
@Entity
@Table(name="informativos")
@NamedQueries({
	@NamedQuery(name = "Informativo.findAll", query = "SELECT i FROM Informativo i"),
	@NamedQuery(name = "Informativo.findById", query = "SELECT t FROM Informativo t WHERE t.informativoid =:informativoid") })
public class Informativo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long informativoid;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	@Lob
	private String texto;

	private String titulo;

	public Informativo() {
	}
	public Long getInformativoid() {
		return this.informativoid;
	}

	public void setInformativoid(Long informativoid) {
		this.informativoid = informativoid;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	@Override
	public String toString() {
		return "Informativo [informativoid=" + informativoid + ", data=" + data
				+ ", texto=" + texto + ", titulo=" + titulo + "]";
	}
	

}