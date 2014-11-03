package com.algures.teste;

import java.util.List;

import org.junit.Test;

import com.algures.dao.DisciplinaDAO;
import com.algures.model.Disciplina;

public class DisciplinaTest {
	@Test
	public void listar() {

		DisciplinaDAO dao = new DisciplinaDAO();
		List<Disciplina> obj = dao.listar();

		for (Disciplina info : obj) {
			System.out.println(info);
		}
	}

}
