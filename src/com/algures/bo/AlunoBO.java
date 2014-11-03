package com.algures.bo;

import java.util.List;

import com.algures.dao.AlunoDAO;
import com.algures.model.Aluno;
import com.algures.model.Endereco;

public class AlunoBO {

	public static void salvar(Aluno aluno, Endereco endereco) {

		AlunoDAO pessoaDAO = new AlunoDAO();
		try {
			aluno.setEndereco(endereco);
			pessoaDAO.salvar(aluno);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static List<Aluno> listarALunos() {
		AlunoDAO dao = new AlunoDAO();
		return dao.listar();
	}
	
	
	public static Aluno editar(Aluno aluno){
		AlunoDAO dao = new AlunoDAO();
		try {
			dao.editar(aluno);
		} catch (Exception e) {
			System.out.println("Error alunoBO! Editar aluno");
			e.printStackTrace();
		}
		return aluno;
				
	}
}
