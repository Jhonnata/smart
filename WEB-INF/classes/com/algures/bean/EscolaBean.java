package com.algures.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.algures.bo.EscolaBO;
import com.algures.model.Endereco;
import com.algures.model.Escola;

@ManagedBean
@SessionScoped
public class EscolaBean {

	private Escola escola;
	private Endereco endereco;

	private List<Escola> escolas;

	public EscolaBean() {
		escola = new Escola();
		endereco = new Endereco();
	}

	public void newObject() {
		escola = new Escola();
		endereco = new Endereco();
		escolas = null;
	}

	public String salvar() {
      String retornar = null;
		try {
			if (!escola.getNome().isEmpty()
					&& !escola.getCodigo().isEmpty())
			{
				EscolaBO.salvar(escola, endereco);
				newObject();
				FacesMessage msg = new FacesMessage("Salvar", "Registro Salvo");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				retornar = "../administrator/index.jsf";
			}
			else{
				FacesMessage msg = new FacesMessage("Campos Obrigatórios", "Preencha todos os campos obrigatórios!");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				retornar = "";
			}
				
		} catch (Exception e) {
			
			FacesMessage msg = new FacesMessage("Error!", "Ocorreu um erro ao salvar o registro!"+e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, msg);
			retornar = "escola";
		}
		return retornar;
	}

	public void getById(Long key) {
		EscolaBO.getById(key);
	}

	public List<Escola> getEscolas() {
		if (!escolas.isEmpty()) {
			escolas = EscolaBO.listEscola();
		}
		return escolas;
	}

	public void setEscolas(List<Escola> escolas) {
		this.escolas = escolas;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}

}
