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
		info2.setTitulo("NOTÍCIAS DE TEST 2");
		info2.setTexto("Testando notícias referente a inserção,"
				+ "ADFD ASDFD DADSFD JKLÇ AÇSDFJ ADÇSFJ AÇSLDFJ AASÇLDFJA S"
				+ "AÇSDFJA SDFAÇLSDJFA JASDFLAJ SDAÇLSDFJA SDLÇJAÇLSDJF ASDÇL"
				+ " AÇSDJA ÇSDLFAJSD FLAJSDF LAÇSDJF ALÇSDKJFA SDLÇFJA SDFÇJ"
				+ " AÇSDJFAÇSDLFJASÇLDFJ AJASDJ KJAS DLJF AÇLSDJF AJASÇLKDJF "
				+ "carcteres.");
		NoticiaDAO infoDAO = new NoticiaDAO();
			
		try {
			infoDAO.salvar(info2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
