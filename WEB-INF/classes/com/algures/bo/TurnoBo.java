package com.algures.bo;

import java.util.List;

import com.algures.dao.TurnoDAO;
import com.algures.model.Turno;

public class TurnoBo {

	public static List<Turno> getTurnos() {
		TurnoDAO dao = new TurnoDAO();
		return dao.listar();
	}
}
