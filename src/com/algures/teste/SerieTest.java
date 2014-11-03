package com.algures.teste;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.algures.dao.EscolaDAO;
import com.algures.dao.SerieDAO;
import com.algures.model.Escola;
import com.algures.model.Serie;

public class SerieTest {
	@Test
	@Ignore
	public void salvar() throws Exception {

		Serie serie = new Serie();
		serie.setNome("1º ANO");
		serie.setAno("ENSINO MÉDIO");
		EscolaDAO retornaEscola = new EscolaDAO();
		Escola escola = retornaEscola.findById(201402L);
		serie.setEscola(escola);
		SerieDAO dao = new SerieDAO();
		dao.salvar(serie);
	}
	
	@Test
	public  void listar(){
		
		SerieDAO dao = new SerieDAO();
		List<Serie> serie = dao.listar();
		for (Serie info : serie) {
			System.out.println(info);
		}
	}
	
	@Test
	@Ignore
	public  void listar2(){
		
		SerieDAO dao = new SerieDAO();
		List<Serie> serie = dao.listarByEscola(201407L);
		for (Serie info : serie) {
			System.out.println(info);
		}
	}
}
