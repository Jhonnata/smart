package com.algures.bo;

import java.util.List;

import com.algures.dao.InformativoDAO;
import com.algures.model.Informativo;

public class InfoBO {

	public void salvar(Informativo info) {
		InformativoDAO infoDAO = new InformativoDAO();
		try {
			infoDAO.salvar(info);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static List<Informativo> getInfo(){
		
		InformativoDAO infoDAO = new InformativoDAO();
		try {
			return infoDAO.listar();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
