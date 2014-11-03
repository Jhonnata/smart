package com.algures.teste;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.algures.dao.TurnoDAO;
import com.algures.model.Turno;

public class TurnoDAOTest {

	@Test
	@Ignore
	public void salvar() throws Exception {

		Turno turno = new Turno();
		turno.setTurno("MATUTINO");
		turno.setObs("Aulas na parte da manhã");

		TurnoDAO dao = new TurnoDAO();
		dao.salvar(turno);
	}
	
	@Test
	
	public  void listar(){
		
		TurnoDAO dao = new TurnoDAO();
		List<Turno> turnos = dao.listar();
		
		for (Turno info : turnos) {
			System.out.println(info);
		}
	}
}
