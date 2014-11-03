package com.algures.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.algures.model.Noticia;
import com.algures.util.HibernateUtil;

public class NoticiaDAO {
	public void salvar(Noticia obj)throws Exception {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = session.beginTransaction();
			session.save(obj);
			transacao.commit();			
		} catch (RuntimeException ex) {

			if(transacao != null){
				transacao.rollback();
			}			
			throw ex;
		}
		finally{			
			session.close();
		}
		
	}//fim salvar
	
	public void editar(Noticia obj)throws Exception {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try {
			transacao = session.beginTransaction();
			session.update(obj);
			transacao.commit();			
				//quando não validar em tela colocar como abaixo!
				// TbInformativo infoEdit = findById(info.getInformativoid());
				// infoEdit.setTitulo(info.getTitulo());
				// infoEdit.setData(info.getData());
				// infoEdit.setTexto(info.getTexto());
			
		} catch (RuntimeException ex) {

			if(transacao != null){
				transacao.rollback();
			}			
			throw ex;
		}
		finally{			
			session.close();
		}
		
	}//fim editar
	
public void excluir(Long key)throws Exception {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = session.beginTransaction();
			Noticia obj = findById(key);
			session.delete(obj);
			transacao.commit();			
		} catch (RuntimeException ex) {

			if(transacao != null){
				transacao.rollback();
			}			
			throw ex;
		}
		finally{			
			session.close();
		}
		
	}//fim excluir

public Noticia findById(Long key){
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	Noticia obj = null;
	try {
		Query  consulta = session.getNamedQuery("Noticia.findById");
		consulta.setLong("noticiaid",key);
		obj = (Noticia) consulta.uniqueResult();
	} catch (RuntimeException ex) {
		throw ex;
	}
	finally{	
		session.close();
	}
	return obj;
}
@SuppressWarnings("unchecked")
public List<Noticia> listar(){
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	
	List<Noticia> objList = null;
	try {

		Criteria crit = session.createCriteria(Noticia.class);
		
		  objList = crit.list();

	} catch (RuntimeException ex) {
		throw ex;
	}
	finally{	
		session.close();
	}
	return objList;
}

	
	
}
