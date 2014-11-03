package com.algures.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.algures.model.Escola;
import com.algures.util.HibernateUtil;

public class EscolaDAO {

	public void salvar(Escola obj) throws Exception {
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

	public Escola findById(Long key) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Escola escola = null;
		try {
			Query consulta = session.getNamedQuery("Escola.findById");
			consulta.setLong("escolaid", key);
			escola = (Escola) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return escola;
	}
	@SuppressWarnings("unchecked")
	public List<Escola> listar(){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		List<Escola> objList = null;
		try {

			Criteria crit = session.createCriteria(Escola.class);
			
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
