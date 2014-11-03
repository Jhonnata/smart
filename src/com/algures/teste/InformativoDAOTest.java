package com.algures.teste;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.algures.dao.InformativoDAO;
import com.algures.model.Informativo;

public class InformativoDAOTest {

	@Test
	public void salvar() {

		Date data = new Date();
		Informativo info = new Informativo();

		info.setData(data);
		System.out.println(data);
		info.setTitulo("DESFILES DE CARROÇA");
		info.setTexto("Este evento ocorre todo ano,"
				+ "aqui na cidade de Brasília de Minas "
				+ "criado pela E.E Santana.");
		InformativoDAO infoDAO = new InformativoDAO();
		System.out.println(info.getInformativoid());

		try {
			infoDAO.salvar(info);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

	@Test
	@Ignore
	public void listar() {

		InformativoDAO dao = new InformativoDAO();
		List<Informativo> informativos = dao.listar();

		for (Informativo info : informativos) {
			System.out.println(info.getData());
		}
	}

	@Test
	@Ignore
	public void findById() {

		InformativoDAO dao = new InformativoDAO();
		Informativo info = dao.findById(1L);
		// Informativo info2 = dao.findById(7L);
		System.out.println(info);
		// System.out.println(info2);
	}

	@Test
	@Ignore
	public void excluir() {

		InformativoDAO dao = new InformativoDAO();
		try {
			dao.excluir(4L);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	@Ignore
	public void editar() {

		Date data = new Date();
		Informativo info2 = new Informativo();
		info2.setData(data);
		info2.setTitulo("JUnit test - editado!");
		info2.setTexto("JUnit teste, para a tabela informativo,"
				+ "verificando o tamanho do campo texto, padrão de 255 "
				+ "carcteres.(UPDATE)");

		info2.setInformativoid(3L);
		InformativoDAO infoDAO = new InformativoDAO();

		try {
			infoDAO.editar(info2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

}
