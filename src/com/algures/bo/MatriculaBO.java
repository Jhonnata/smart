package com.algures.bo;

import java.util.List;

import com.algures.dao.MatriculaDAO;
import com.algures.dao.TurmaDAO;
import com.algures.model.Matricula;
import com.algures.model.Turma;

public class MatriculaBO {
	
	public static void salvar(Matricula matricula, Long idTurma) {
		TurmaDAO daoTurma = new TurmaDAO();
		MatriculaDAO matricular = new MatriculaDAO();
		try {
			 Turma turma = daoTurma.findById(idTurma);
			 matricula.setTurma(turma);
			 matricular.salvar(matricula);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<Matricula> getMatriculas(){
		MatriculaDAO matricula = new MatriculaDAO();
		return matricula.listar();
	}
	
	public static List<Matricula> listByTurma(Long key){
		MatriculaDAO matricula = new MatriculaDAO();
		return matricula.listByTurma(key);
	}
	
	public static Integer getQtdMatriculas(){
		MatriculaDAO matricula = new MatriculaDAO();
		return matricula.getQtdMatriculas();
	}

}
