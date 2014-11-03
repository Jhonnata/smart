package com.algures.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.algures.model.Turno;
import com.algures.util.HibernateUtil;

public class TurnoDAO {
	
	public void salvar(Turno obj)throws Exception {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = session.beginTransaction();
			session.save(obj);
			transacao.commit();			
		} catch (RuntimeException ex) {

			if(transacao != null){
				transacao.rollback();
			}			
			throw ex;
		}
		finally{			
			session.close();
		}
		
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<Turno> listar(){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		List<Turno> objList = null;
		try {
			//Query  consulta = session.getNamedQuery("Turno.findAll");
			Criteria crit = session.createCriteria(Turno.class);
			
			  objList = crit.list();

			//objList = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		}
		finally{	
			session.close();
		}
		return objList;
	}
	
	
	
	public Turno findById(Long key){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Turno obj = null;
		try {
			Query  consulta = session.getNamedQuery("Turno.findById");
			consulta.setLong("turnoid",key);
			obj = (Turno) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		}
		finally{	
			session.close();
		}
		return obj;
	}
	
	
	public void excluir(Long key)throws Exception {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = session.beginTransaction();
			Turno obj = findById(key);
			session.delete(obj);
			transacao.commit();			
		} catch (RuntimeException ex) {

			if(transacao != null){
				transacao.rollback();
			}			
			throw ex;
		}
		finally{			
			session.close();
		}
		
	}
	
	
	public void editar(Turno obj)throws Exception {
	
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try {
			transacao = session.beginTransaction();
			session.update(obj);
			transacao.commit();			
				//quando não validar em tela colocar como abaixo!
				// TbInformativo infoEdit = findById(info.getInformativoid());
				// infoEdit.setTitulo(info.getTitulo());
				// infoEdit.setData(info.getData());
				// infoEdit.setTexto(info.getTexto());
			
		} catch (RuntimeException ex) {

			if(transacao != null){
				transacao.rollback();
			}			
			throw ex;
		}
		finally{			
			session.close();
		}
		
	}
}
