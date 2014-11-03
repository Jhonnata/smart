package com.algures.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


/**
 * The persistent class for the alunos database table.
 * 
 */
@Entity
@Table(name="alunos")
@NamedQueries({
	@NamedQuery(name="Aluno.findAll", query="SELECT a FROM Aluno a"),
	@NamedQuery(name = "Aluno.findById", query = "SELECT a FROM Aluno a WHERE a.ra =:ra")})
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long ra;
	@Temporal(TemporalType.DATE)
	private Date anoinicio;

	@Temporal(TemporalType.DATE)
	private Date datanasc;

	@Column(name="EMAIL_A")
	private String emailA;

	@Column(name="EMAIL_R")
	private String emailR;

	private String fone;

	private String sexo;
	
	private String nome;

	private String nomemae;

	private String nomepai;

	private String rg;

	private String senha;

	private String urlfoto;

	@ManyToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name="ENDERECOID")
	private Endereco endereco;

	public Aluno() {
	}

	public Long getRa() {
		return this.ra;
	}

	public void setRa(Long ra) {
		this.ra = ra;
	}

	public Date getAnoinicio() {
		return this.anoinicio;
	}

	public void setAnoinicio(Date anoinicio) {
		this.anoinicio = anoinicio;
	}

	public Date getDatanasc() {
		return this.datanasc;
	}

	public void setDatanasc(Date datanasc) {
		this.datanasc = datanasc;
	}

	public String getEmailA() {
		return this.emailA;
	}

	public void setEmailA(String emailA) {
		this.emailA = emailA;
	}

	public String getEmailR() {
		return this.emailR;
	}

	public void setEmailR(String emailR) {
		this.emailR = emailR;
	}

	public String getFone() {
		return this.fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomemae() {
		return this.nomemae;
	}

	public void setNomemae(String nomemae) {
		this.nomemae = nomemae;
	}

	public String getNomepai() {
		return this.nomepai;
	}

	public void setNomepai(String nomepai) {
		this.nomepai = nomepai;
	}

	public String getRg() {
		return this.rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUrlfoto() {
		return this.urlfoto;
	}

	public void setUrlfoto(String urlfoto) {
		this.urlfoto = urlfoto;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Aluno [ra=" + ra + ", anoinicio=" + anoinicio + ", datanasc="
				+ datanasc + ", emailA=" + emailA + ", emailR=" + emailR
				+ ", fone=" + fone + ", sexo=" + sexo + ", nome=" + nome
				+ ", nomemae=" + nomemae + ", nomepai=" + nomepai + ", rg="
				+ rg + ", senha=" + senha + ", urlfoto=" + urlfoto
				+ ", endereco=" + endereco + "]";
	}

	
}