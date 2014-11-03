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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;



/**
 * The persistent class for the professores database table.
 * 
 */
@Entity
@Table(name="professores")

@NamedQueries({
	@NamedQuery(name="Professor.findAll", query="SELECT p FROM Professor p"),
	@NamedQuery(name = "Professor.findById", query = "SELECT p FROM Professor p WHERE p.professoresid=:professoresid")})
public class Professor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long professoresid;

	private String cpf;

	private String email;

	private String nome;

	private String senha;

	private String urlfoto;

	@ManyToOne
	@JoinColumn(name="DISCIPLINAID")
	private Disciplina disciplina;

	@ManyToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name="ENDERECOID")
	private Endereco endereco;

	public Professor() {
	}

	public Long getProfessoresid() {
		return this.professoresid;
	}

	public void setProfessoresid(Long professoresid) {
		this.professoresid = professoresid;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public Disciplina getDisciplina() {
		return this.disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Professor [professoresid=" + professoresid + ", cpf=" + cpf
				+ ", email=" + email + ", nome=" + nome + ", senha=" + senha
				+ ", urlfoto=" + urlfoto + ", disciplina=" + disciplina
				+ ", endereco=" + endereco + "]";
	}

}