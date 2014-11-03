package com.algures.teste;

import org.junit.Test;

import com.algures.util.HibernateUtil;

public class HibernateTest {

	@Test
	public void gerar(){
		
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
		
	}
	
}
