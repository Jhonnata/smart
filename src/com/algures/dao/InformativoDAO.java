package com.algures.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.algures.model.Informativo;
import com.algures.util.HibernateUtil;

public class InformativoDAO {

	public void salvar(Informativo info) throws Exception {
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
	public List<Informativo> listar() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Informativo> informativos = null;
		try {
			Query consulta = session.getNamedQuery("Informativo.findAll");
			informativos = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return informativos;
	}

	public Informativo findById(Long key) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Informativo info = null;
		try {
			Query consulta = session.getNamedQuery("Informativo.findById");
			consulta.setLong("informativoid", key);
			info = (Informativo) consulta.uniqueResult();
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
			Informativo info = findById(key);
			session.delete(info);
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

	public void editar(Informativo info) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = session.beginTransaction();
			session.update(info);
			transacao.commit();
			// quando não validar em tela colocar como abaixo!
			// TbInformativo infoEdit = findById(info.getInformativoid());
			// infoEdit.setTitulo(info.getTitulo());
			// infoEdit.setData(info.getData());
			// infoEdit.setTexto(info.getTexto());

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
