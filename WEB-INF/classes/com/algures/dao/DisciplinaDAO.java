package com.algures.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.algures.model.Disciplina;
import com.algures.util.HibernateUtil;

public class DisciplinaDAO {

	public void salvar(Disciplina obj) throws Exception {

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

	public Disciplina findById(Long key) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Disciplina obj = null;
		try {
			Query consulta = session.getNamedQuery("Disciplina.findById");
			consulta.setLong("disciplinaid", key);
			obj = (Disciplina) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return obj;
	}

	@SuppressWarnings("unchecked")
	public List<Disciplina> listar() {

		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Disciplina> objList = null;
		try {
			Query consulta = session.getNamedQuery("Disciplina.findAll");
			objList = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return objList;
	}

}
