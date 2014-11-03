package com.algures.teste;

import java.util.Date;

import org.junit.Test;

import com.algures.dao.NoticiaDAO;
import com.algures.model.Noticia;

public class NoticiaDAOTest {

	@Test
	public void salvar(){
		Date data = new Date();
		Noticia info2 = new Noticia();
		info2.setData(data);
		System.out.println(data);
		info2.setTitulo("NOT�CIAS DE TEST 2");
		info2.setTexto("Testando not�cias referente a inser��o,"
				+ "ADFD ASDFD DADSFD JKL� A�SDFJ AD�SFJ A�SLDFJ AAS�LDFJA S"
				+ "A�SDFJA SDFA�LSDJFA JASDFLAJ SDA�LSDFJA SDL�JA�LSDJF ASD�L"
				+ " A�SDJA �SDLFAJSD FLAJSDF LA�SDJF AL�SDKJFA SDL�FJA SDF�J"
				+ " A�SDJFA�SDLFJAS�LDFJ AJASDJ KJAS DLJF A�LSDJF AJAS�LKDJF "
				+ "carcteres.");
		NoticiaDAO infoDAO = new NoticiaDAO();
			
		try {
			infoDAO.salvar(info2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
