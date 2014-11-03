package com.algures.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.algures.model.Serie;
import com.algures.util.HibernateUtil;

public class SerieDAO {

	public void salvar(Serie obj) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = session.beginTransaction();
			session.save(obj);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			session.close();
		}
	}

	public Serie findById(Long key) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Serie obj = null;
		try {
			Query consulta = session.getNamedQuery("Serie.findById");
			consulta.setLong("serieid", key);
			obj = (Serie) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return obj;
	}
	
	@SuppressWarnings("unchecked")
	public List<Serie> listar(){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		List<Serie> objList = null;
		try {
			Criteria crit = session.createCriteria(Serie.class);
			  objList = crit.list();

		} catch (RuntimeException ex) {
			throw ex;
		}
		finally{	
			session.close();
		}
		return objList;
	}
	@SuppressWarnings("unchecked")
	public List<Serie> listarByEscola(Long key){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Serie> objs = null;
		try {
			Query consulta = session.getNamedQuery("Serie.findSerieEscola");
			consulta.setLong("escolaid", key);
			objs = (List<Serie>) consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return objs;
	}
	
	
}
