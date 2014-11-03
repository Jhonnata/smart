package com.algures.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.algures.model.Matricula;
import com.algures.util.HibernateUtil;

public class MatriculaDAO {
	public void salvar(Matricula info) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = session.beginTransaction();
			session.save(info);
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
	public Matricula findById(Long key) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Matricula info = null;
		try {
			Query consulta = session.getNamedQuery("Matricula.findById");
			consulta.setLong("matriculaid", key);
			info = (Matricula) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return info;
	}
	@SuppressWarnings("unchecked")
	public List<Matricula> listar() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Matricula> matricula = null;
		try {
			Query consulta = session.getNamedQuery("Matricula.findAll");
			matricula = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return matricula;
	}
	@SuppressWarnings("unchecked")
	public List<Matricula> listByTurma(Long key) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Matricula> info = null;
		try {
			Query consulta = session.getNamedQuery("Matricula.listByTurma");
			consulta.setLong("turmaid", key);
			info = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return info;
	}
	
	public void editar(Matricula info) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = session.beginTransaction();
			session.update(info);
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
	public Integer getQtdMatriculas() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Integer numMatriculas;
		try {
			Query consulta = session.getNamedQuery("Matricula.findAll");
			 numMatriculas = consulta.getMaxResults();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return numMatriculas;
	}
}
