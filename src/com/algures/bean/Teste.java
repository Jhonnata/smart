package com.algures.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.algures.bo.MatriculaBO;

@ManagedBean
@RequestScoped
public class Teste {

	private Integer maxMatricula;
	public Teste() {
		// TODO Auto-generated constructor stub
	}
	public Integer getMaxMatricula() {
		maxMatricula = MatriculaBO.getQtdMatriculas();
		return maxMatricula;
	}
	public void setMaxMatricula(Integer maxMatricula) {
		this.maxMatricula = maxMatricula;
	}
	
	
}
