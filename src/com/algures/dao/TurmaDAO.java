package com.algures.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;





import com.algures.model.Turma;
import com.algures.util.HibernateUtil;

public class TurmaDAO {
	
	public void salvar(Turma info) throws Exception {
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

	@SuppressWarnings("unchecked")
	public List<Turma> listar() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Turma> informativos = null;
		try {
			Query consulta = session.getNamedQuery("Turma.findAll");
			informativos = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return informativos;
	}

	public Turma findById(Long key) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Turma info = null;
		try {
			Query consulta = session.getNamedQuery("Turma.findById");
			consulta.setLong("turmaid",key);
			info = (Turma) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return info;
	}

	public void excluir(Long key) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = session.beginTransaction();
			Turma info = findById(key);
			session.delete(info);
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

	public void editar(Turma info) throws Exception {
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

	@SuppressWarnings("unchecked")
	public List<Turma> listBySerie(Long key) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Turma> info = null;
		try {
			Query consulta = session.getNamedQuery("Turma.listBySerie");
			consulta.setLong("serieid", key);
			info = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return info;
	}
}
