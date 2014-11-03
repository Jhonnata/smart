package com.algures.teste;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.algures.dao.EnderecoDAO;
import com.algures.dao.EscolaDAO;
import com.algures.model.Endereco;
import com.algures.model.Escola;

public class EscolaDAOTest {

	@Test
	@Ignore
	public void salvar() {

		Endereco endereco = new Endereco();
		endereco.setRua("Av. Bias Fortes");
		endereco.setNumero("271");
		endereco.setBairro("Vale das Palmeiras");
		endereco.setCep("39330000");
		endereco.setCidade("Brasília de Minas");
		endereco.setEstado("MG");

		Escola escola = new Escola();
		escola.setNome("E.E SANTANA");
		escola.setCodigo("135");

		EnderecoDAO enderecoDao = new EnderecoDAO();
		EscolaDAO dao = new EscolaDAO();
		try {
			Endereco escolaEndereco = enderecoDao.salvar(endereco);
			escola.setEndereco(escolaEndereco);
			dao.salvar(escola);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	@Test
	@Ignore
	public void findById(){
		
		EscolaDAO  dao = new EscolaDAO();
		Escola info = dao.findById(201401L);
		//Informativo info2 = dao.findById(7L);
		System.out.println(info.getNome());
	}
	@Test
	public  void listar(){
		EscolaDAO dao = new EscolaDAO();
		List<Escola> escola = dao.listar();
		for (Escola info : escola) {
			System.out.println(info.getNome());
		}
	}
	
	
}
