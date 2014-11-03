package com.algures.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.algures.model.Prova;
import com.algures.util.HibernateUtil;

public class ProvaDAO {

	public void salvar(Prova obj) throws Exception {

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

	public Prova findById(Long key) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Prova obj = null;
		try {
			Query consulta = session.getNamedQuery("Prova.findById");
			consulta.setLong("provaid", key);
			obj = (Prova) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return obj;
	}
	public Double mediaEscola() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query consulta = session.getNamedQuery("Prova.mediaEscola");
			Double media = (Double) consulta.uniqueResult();
			return media;
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Prova> listar() {

		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Prova> objList = null;
		try {
			Criteria crit = session.createCriteria(Prova.class);
			objList = crit.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return objList;
	}

	public void excluir(Long key) throws Exception {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = session.beginTransaction();
			Prova obj = findById(key);
			session.delete(obj);
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

	public void editar(Prova obj) throws Exception {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = session.beginTransaction();
			session.update(obj);
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
}
