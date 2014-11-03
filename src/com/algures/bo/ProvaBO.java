package com.algures.bo;

import java.util.List;

import com.algures.dao.AlunoDAO;
import com.algures.dao.DisciplinaDAO;
import com.algures.dao.MatriculaDAO;
import com.algures.dao.ProvaDAO;
import com.algures.model.Aluno;
import com.algures.model.Disciplina;
import com.algures.model.Matricula;
import com.algures.model.Prova;

public class ProvaBO {

	public static void saver(Prova prova,long idMatricula,long idDisciplina){
		ProvaDAO provaDao = new ProvaDAO();
		MatriculaDAO matriculaDao = new MatriculaDAO();
		DisciplinaDAO disciplinaDao = new DisciplinaDAO();
		try {
			Matricula matricula = matriculaDao.findById(idMatricula);
			Disciplina disciplina = disciplinaDao.findById(idDisciplina);
			prova.setDisciplina(disciplina);
			prova.setMatricula(matricula);
			provaDao.salvar(prova);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<Aluno> getAlunosSerie(long Key){
		AlunoDAO dao = new AlunoDAO();
		return dao.findByIdSerie(Key);
	}

	public static List<Prova> getProvas() {
		ProvaDAO dao = new ProvaDAO();
		return dao.listar();
	}
}
