package com.algures.bo;

import java.util.List;

import com.algures.dao.DisciplinaDAO;
import com.algures.dao.ProfessorDAO;
import com.algures.model.Disciplina;
import com.algures.model.Endereco;
import com.algures.model.Professor;

public class ProfessorBO {

	public static List<Professor> listarProfessor() {
		ProfessorDAO dao = new ProfessorDAO();
		List<Professor> profs = null;
		try {
			profs = dao.listar();
		} catch (Exception e) {
			throw e;
		}
		return profs;
	}

	public static void salvar(Professor professor, Endereco endereco,
			Long keyDisciplina) {
		try {
			DisciplinaDAO daoDisciplina = new DisciplinaDAO();
			Disciplina disciplina = daoDisciplina.findById(keyDisciplina);
			professor.setDisciplina(disciplina);
			professor.setEndereco(endereco);
			ProfessorDAO pessoaDAO = new ProfessorDAO();
			pessoaDAO.salvar(professor);
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
