package com.algures.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the enderecos database table.
 * 
 */
@Entity
@Table(name="enderecos")
@NamedQuery(name="Endereco.findAll", query="SELECT e FROM Endereco e")
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long enderecoid;

	private String bairro;

	private String cep;

	private String cidade;

	private String complemento;

	private String estado;

	private String numero;

	private String rua;


	public Endereco() {
	}

	public Long getEnderecoid() {
		return this.enderecoid;
	}

	public void setEnderecoid(Long enderecoid) {
		this.enderecoid = enderecoid;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRua() {
		return this.rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	@Override
	public String toString() {
		return "Endereco [enderecoid=" + enderecoid + ", bairro=" + bairro
				+ ", cep=" + cep + ", cidade=" + cidade + ", complemento="
				+ complemento + ", estado=" + estado + ", numero=" + numero
				+ ", rua=" + rua + "]";
	}
	
}