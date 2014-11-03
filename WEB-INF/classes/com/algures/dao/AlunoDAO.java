package com.algures.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.algures.model.Aluno;
import com.algures.util.HibernateUtil;

public class AlunoDAO {
	
	public Aluno salvar(Aluno obj) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = session.beginTransaction();
			Aluno aluno = (Aluno) session.merge(obj);
			transacao.commit();
			return aluno;
		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			session.close();
		}

	}
	
	
	public Aluno findById(Long key) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Aluno obj = null;
		try {
			Query consulta = session.getNamedQuery("Aluno.findById");
			consulta.setLong("pessoaid", key);
			obj = (Aluno) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return obj;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<Aluno> findByIdSerie(Long key) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Aluno> obj = null;
		try {
			Query consulta = session.getNamedQuery("Aluno.findByIdSerie");
			consulta.setLong("SERIEID", key);
			obj = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return obj;
	}


	@SuppressWarnings("unchecked")
	public List<Aluno> listar() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Aluno> objList = null;
		try {
			Criteria crit = session.createCriteria(Aluno.class);

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
			Aluno obj = findById(key);
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
	public void editar(Aluno obj) throws Exception {

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
