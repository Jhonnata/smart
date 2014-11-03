package com.algures.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.algures.util.HibernateUtil;

public class GenericDAO {
	
	public void salvar(Object obj) throws Exception {
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

	@SuppressWarnings("unchecked")
	public List<Object> listar(String consulta) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Object> listObj = null;
		try {
			Query query = session.getNamedQuery(consulta);
			listObj = query.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return listObj;
	}

	public Object findById(Long key,String campo,String consulta) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Object obj = null;
		try {
			Query query = session.getNamedQuery(consulta);
			query.setLong(campo, key);
			obj = query.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return obj;
	}

	public void excluir(Long key,String campo,String consulta) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = session.beginTransaction();
			Object obj = findById(key,campo,consulta);
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

	public void editar(Object info) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = session.beginTransaction();
			session.update(info);
			transacao.commit();

		} catch (RuntimeException ex) {
			if (transacao != null) {
				System.out.println("Realizando Roll Back");
				transacao.rollback();
			}
			throw ex;
		} finally {
			session.close();
		}
	}

}
