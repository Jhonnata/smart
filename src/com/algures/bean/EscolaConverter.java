package com.algures.bean;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.algures.bo.EscolaBO;
import com.algures.model.Escola;

public class EscolaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1,
			String escolaid) {

		if (escolaid != null && escolaid.trim().length() > 0) {
			Long codigo = Long.valueOf(escolaid);
			return EscolaBO.getById(codigo);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object escolaObj) {
       if(escolaObj!=null){
    	   Escola escola = (Escola) escolaObj;
    	   return escola.toString();
       }
		return null;
	}

}
