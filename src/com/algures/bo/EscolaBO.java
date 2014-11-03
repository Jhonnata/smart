package com.algures.bo;

import java.util.List;

import com.algures.dao.EnderecoDAO;
import com.algures.dao.EscolaDAO;
import com.algures.model.Endereco;
import com.algures.model.Escola;

public class EscolaBO {

	private static EnderecoDAO enderecoDao = new EnderecoDAO();
	private static EscolaDAO dao = new EscolaDAO();

	public static void salvar(Escola escola, Endereco endereco) {
		try {
			if (escola.getNome() != null && endereco.getRua() != null) {
				Endereco escolaEndereco = enderecoDao.salvar(endereco);
				escola.setEndereco(escolaEndereco);
				dao.salvar(escola);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Escola getById(Long key) {
		return dao.findById(key);
	}

	public static List<Escola> listEscola() {
		List<Escola> escola = dao.listar();
		return escola;
	}
}
