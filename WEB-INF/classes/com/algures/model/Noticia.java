package com.algures.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the noticias database table.
 * 
 */
@Entity
@Table(name="noticias")
@NamedQuery(name="Noticia.findAll", query="SELECT n FROM Noticia n")
public class Noticia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long noticiaid;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	@Lob
	private String texto;

	private String titulo;

	public Noticia() {
	}

	public Long getNoticiaid() {
		return this.noticiaid;
	}

	public void setNoticiaid(Long noticiaid) {
		this.noticiaid = noticiaid;
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
		return "Noticia [noticiaid=" + noticiaid + ", data=" + data
				+ ", texto=" + texto + ", titulo=" + titulo + "]";
	}
	

}