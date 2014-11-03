package com.algures.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.algures.model.Endereco;
import com.algures.util.HibernateUtil;

public class EnderecoDAO {

public Endereco salvar(Endereco info)throws Exception {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		Endereco endereco = null;
		try {
			transacao = session.beginTransaction();
			endereco = (Endereco) session.merge(info);
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
		
		return endereco;
		
	}
	
}
