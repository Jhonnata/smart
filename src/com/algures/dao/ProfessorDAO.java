package com.algures.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.algures.model.Professor;
import com.algures.util.HibernateUtil;

public class ProfessorDAO {

	public Professor salvar(Professor obj) throws Exception {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		Professor professor;
		try {
			transacao = session.beginTransaction();
			session.flush();
			professor = (Professor) session.merge(obj);
			transacao.commit();
			return professor;
		} catch (RuntimeException ex) {

			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			session.close();
		}

	}

	public Professor findById(Long key) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Professor obj = null;
		try {
			Query consulta = session.getNamedQuery("Professore.findById");
			consulta.setLong("pessoaid", key);
			obj = (Professor) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return obj;
	}

	@SuppressWarnings("unchecked")
	public List<Professor> listar() {

		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Professor> objList = null;
		try {

			Criteria crit = session.createCriteria(Professor.class);

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
			Professor obj = findById(key);
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

	public void editar(Professor obj) throws Exception {

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
