package com.algures.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.algures.bo.InfoBO;
import com.algures.model.Informativo;

@ManagedBean
@RequestScoped
public class InformaBean {

	private Informativo info;
	@SuppressWarnings("unused")
	private List<Informativo> informativos;

	public InformaBean() {
		info = new Informativo();
	}

	public String salvar() {
		try {
			if (!info.getTitulo().isEmpty() && !info.getTexto().isEmpty()
					&& !info.getData().toString().isEmpty()) {

				InfoBO control = new InfoBO();
				control.salvar(info);
				newObject();
				FacesMessage msg = new FacesMessage("",
						"Informativo Salvo com Sucesso!");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				return "index";
			} else {
				FacesMessage msg = new FacesMessage("Campos Obrigatórios.",
						"Preencha todos os campos obrigatórios!");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				return "";
			}
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage("ERROR",
					"Ocorreu um erro inesperado, preencha novamente o registro e salve!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return null;
		}
	}

	public void newObject() {

		info = new Informativo();
	}

	public Informativo getInfo() {
		return info;
	}

	public void setInfo(Informativo info) {
		this.info = info;
	}

	public List<Informativo> getInformativos() {
		return InfoBO.getInfo();
	}

	public void setInformativos(List<Informativo> informativos) {
		this.informativos = informativos;
	}

}
