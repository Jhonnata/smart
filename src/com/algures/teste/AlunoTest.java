package com.algures.teste;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.algures.dao.AlunoDAO;
import com.algures.model.Aluno;
import com.algures.model.Endereco;

public class AlunoTest {

	@Test
	public void salvar() throws Exception {

		Endereco endereco = new Endereco();
		endereco.setRua("MG402");
		endereco.setNumero("70");
		endereco.setBairro("ALTO CLARO");
		endereco.setCep("39330000");
		endereco.setCidade("Brasília de Minas");
		endereco.setEstado("MG");

		Aluno pessoa = new Aluno();// FUNCIONOU PERFEITAMENTE
		pessoa.setNome("JHESLEY");
		Date data = new Date();
		pessoa.setDatanasc(data);
		pessoa.setSexo("MASCULINO");
		pessoa.setRg("399999999");
		pessoa.setUrlfoto("c://fotos/jhesley");

		pessoa.setEndereco(endereco);
		AlunoDAO pessoaDAO = new AlunoDAO();
		pessoaDAO.salvar(pessoa);
	}

	@Test
	@Ignore
	public void listar() {
		AlunoDAO dao = new AlunoDAO();
		List<Aluno> alunos = dao.listar();
		for (Aluno info : alunos) {
			System.out.println(info);
		}
	}

}
