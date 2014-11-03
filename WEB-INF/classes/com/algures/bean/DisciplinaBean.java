package com.algures.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.algures.bo.DisciplinaBO;
import com.algures.model.Disciplina;

@ManagedBean
@RequestScoped
public class DisciplinaBean {

	private Disciplina disciplina;
	
	public DisciplinaBean() {
		disciplina = new Disciplina();
	}
	
	public void newObject(){
		disciplina = new Disciplina();
	}
	public String salvar(){
		
		try {
			if(!disciplina.getNome().isEmpty()){
			DisciplinaBO.salvar(disciplina);
			newObject();
			FacesMessage msg = new FacesMessage("","Registro Salvo!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return "index.jsf";
			}else {
				FacesMessage msg = new FacesMessage("Campos Obrigatórios","Preencha todos os campos obrigatórios!");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				return "";	
			}
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage("Error!","Tam...");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return null;
		}
	
		
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	

}
