package com.algures.bo;

import java.util.List;

import com.algures.dao.NoticiaDAO;
import com.algures.model.Noticia;

public class NoticiaBO {

	public static void salvar(Noticia info) {

		NoticiaDAO noticiaDao = new NoticiaDAO();
		try {
			noticiaDao.salvar(info);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	public static List<Noticia> getNoticias(){
		NoticiaDAO noticiaDao = new NoticiaDAO();
		try {
			return noticiaDao.listar();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}
}
