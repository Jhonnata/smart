package com.algures.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class UtilBean {

	private List<String> sexo;
	private List<String> estados;
	private List<String> bimestres;
	
	public UtilBean() {
		sexo = new ArrayList<String>();
		sexo.add("");
		sexo.add("Feminino");
		sexo.add("Masculino");
		
		
		bimestres = new ArrayList<String>();
		bimestres.add("");
		bimestres.add("1º BIMESTRE");
		bimestres.add("2º BIMESTRE");
		bimestres.add("3º BIMESTRE");
		bimestres.add("4º BIMESTRE");
		
		
		estados = new ArrayList<String>();
		estados.add("");
		estados.add("AC");
		estados.add("AL");
		estados.add("AM");
		estados.add("AP");
		estados.add("BA");
		estados.add("CE");
		estados.add("DF");
		estados.add("ES");
		estados.add("GO");
		estados.add("MA");
		estados.add("MG");
		estados.add("MS");
		estados.add("MT");
		estados.add("PA");
		estados.add("PB");
		estados.add("PE");
		estados.add("PI");
		estados.add("PR");
		estados.add("RJ");
		estados.add("RN");
		estados.add("RO");
		estados.add("RR");
		estados.add("RS");
		estados.add("SC");
		estados.add("SE");
		estados.add("SP");
		estados.add("TO");
	}
	
	public List<String> getSexo() {
		return sexo;
	}

	public void setSexo(List<String> sexo) {
		this.sexo = sexo;
	}

	public List<String> getEstados() {
		return estados;
	}

	public void setEstados(List<String> estados) {
		this.estados = estados;
	}

	
	public List<String> getBimestres() {
		return bimestres;
	}

	public void setBimestres(List<String> bimestres) {
		this.bimestres = bimestres;
	}
	
	
	

}
