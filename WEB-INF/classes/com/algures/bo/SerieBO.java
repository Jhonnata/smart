package com.algures.bo;

import java.util.List;

import com.algures.dao.EscolaDAO;
import com.algures.dao.SerieDAO;
import com.algures.model.Escola;
import com.algures.model.Serie;

public class SerieBO {

	public static void salvar(Serie serie, Long keyEscola,Long keyTurno) {

		SerieDAO dao = new SerieDAO();
		EscolaDAO daoEscola = new EscolaDAO();
		
		Escola escola;
		try {
			escola = daoEscola.findById(keyEscola);
				serie.setEscola(escola);
				dao.salvar(serie);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<Serie> getSeries() {
		SerieDAO dao = new SerieDAO();
		return dao.listar();
	}
	
	public static List<Serie> getSeriesByEscola(Long key) {
		SerieDAO dao = new SerieDAO();
		return dao.listarByEscola(key);
	}
	
	public static Serie findById(Long key){
		SerieDAO dao = new SerieDAO();
		return dao.findById(key);
	}

}
