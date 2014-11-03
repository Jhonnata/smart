package com.algures.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.algures.bo.ProvaBO;
import com.algures.model.Prova;

@ManagedBean
@RequestScoped
public class ProvaBean {

	private Prova prova;

	/**
	 * 
	 * PEGAR O IDSERIE E REALIZAR A QUERY, DEPOIS IR PULANDO DE RELACIONAMENTO E
	 * GRAVAR NO BANCO
	 */
	private Long idDisciplinaSelected;
	private Long idMatriculaSelected;

	public ProvaBean() {
		prova = new Prova();
	}

	public void newObject() {
		prova = new Prova();
	}

	public String salvar() {
		String retorno = null;
		try {
			if(!prova.getBimestre().isEmpty()&& 
					!String.valueOf(prova.getNota()).isEmpty() &&
					 idDisciplinaSelected !=null &&
					 idMatriculaSelected !=null){
			ProvaBO.saver(prova, idMatriculaSelected, idDisciplinaSelected);
			newObject();
			FacesMessage msg = new FacesMessage("", "Registro Salvo");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			retorno =  "../administrator/index.jsf";
			}else{
				FacesMessage msg = new FacesMessage("Campos Obrigatórios.", "Preencha todos os campos obrigatórios");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
			
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage("ERROR", "Ocorreu um erro inesperado, entre com o registro novamente!SSSSSSS");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			e.getMessage();
		}
		return retorno;
	}

	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}

	public Long getIdDisciplinaSelected() {
		return idDisciplinaSelected;
	}

	public void setIdDisciplinaSelected(Long idDisciplinaSelected) {
		this.idDisciplinaSelected = idDisciplinaSelected;
	}

	public Long getIdMatriculaSelected() {
		return idMatriculaSelected;
	}

	public void setIdMatriculaSelected(Long idMatriculaSelected) {
		this.idMatriculaSelected = idMatriculaSelected;
	}

}
