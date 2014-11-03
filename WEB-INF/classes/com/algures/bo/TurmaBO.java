package com.algures.bo;

import java.util.List;

import com.algures.dao.SerieDAO;
import com.algures.dao.TurmaDAO;
import com.algures.dao.TurnoDAO;
import com.algures.model.Serie;
import com.algures.model.Turma;
import com.algures.model.Turno;

public class TurmaBO {
	
	public static void salvar(Turma turma, Long keySerie,Long keyTurno) {
		TurmaDAO dao = new TurmaDAO();
		SerieDAO daoSerie = new SerieDAO();
		TurnoDAO daoTurno = new TurnoDAO();
		Serie serie;
		Turno turno;
		try {
			serie = daoSerie.findById(keySerie);
			turno = daoTurno.findById(keyTurno);
			    turma.setTurno(turno);
				turma.setSery(serie);
				dao.salvar(turma);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<Turma> getTurmas() {
		TurmaDAO dao = new TurmaDAO();
		return dao.listar();
	}
	
	
	
	public static List<Turma> getTurmasBySerie(Long key) {
		TurmaDAO dao = new TurmaDAO();
		return dao.listBySerie(key);
	}
	
	public static Turma findById(Long key){
		TurmaDAO dao = new TurmaDAO();
		return dao.findById(key);
	}

	public static void update(Object newValue) {
		TurmaDAO dao = new TurmaDAO();
		try {
			dao.editar((Turma) newValue);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
