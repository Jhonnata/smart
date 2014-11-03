package com.algures.bo;

import java.util.List;

import com.algures.dao.DisciplinaDAO;
import com.algures.model.Disciplina;


public class DisciplinaBO {

	public static List<Disciplina> listDisciplina() {
		DisciplinaDAO dao = new DisciplinaDAO();
		List<Disciplina> disciplinas = dao.listar();
		return disciplinas;
	}

	public static void salvar(Disciplina disciplina) {
		
		DisciplinaDAO dao = new DisciplinaDAO();
		try {
			if(!disciplina.getNome().isEmpty()){
				dao.salvar(disciplina);
			} else {
				
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
