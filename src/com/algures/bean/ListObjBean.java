package com.algures.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.primefaces.event.RowEditEvent;

import com.algures.bo.AlunoBO;
import com.algures.bo.DisciplinaBO;
import com.algures.bo.EscolaBO;
import com.algures.bo.MatriculaBO;
import com.algures.bo.ProfessorBO;
import com.algures.bo.ProvaBO;
import com.algures.bo.SerieBO;
import com.algures.bo.TurmaBO;
import com.algures.bo.TurnoBo;
import com.algures.model.Aluno;
import com.algures.model.Disciplina;
import com.algures.model.Escola;
import com.algures.model.Matricula;
import com.algures.model.Professor;
import com.algures.model.Prova;
import com.algures.model.Serie;
import com.algures.model.Turma;
import com.algures.model.Turno;

@ManagedBean
@ViewScoped
public class ListObjBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Escola> escolas;
	private List<Serie> series;
	private List<Turno> turnos;
	private List<Turma> turmas;
	private List<Disciplina> disciplinas;
	private List<Professor> professores;
	private List<Aluno> alunos;
	private List<Matricula> matriculas;
	private List<Prova> provas;
	
	
	
	private List<Prova> filteredProvas;

	public ListObjBean() {
	}

	public void changeValuesSerie(ValueChangeEvent event) {
		Long id = Long.valueOf(event.getNewValue().toString());
		setSeries(SerieBO.getSeriesByEscola(id));
	}

	public void changeValuesTurma(ValueChangeEvent event) {
		Long id = Long.valueOf(event.getNewValue().toString());
		setTurmas(TurmaBO.getTurmasBySerie(id));
	}

	public void changeValuesAlunos(ValueChangeEvent event) {
		Long id = Long.valueOf(event.getNewValue().toString());
		setMatriculas(MatriculaBO.listByTurma(id));
	}

	public List<Matricula> getMatriculas() {
		if (matriculas == null) {
			matriculas = MatriculaBO.getMatriculas();
		}
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public List<Serie> getSeries() {
		if (series == null) {
			series = SerieBO.getSeries();
		}
		return series;
	}

	public void setSeries(List<Serie> series) {
		this.series = series;
	}

	public List<Turma> getTurmas() {
		if (turmas == null) {
			turmas = TurmaBO.getTurmas();
		}
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public List<Disciplina> getDisciplinas() {
		if (disciplinas == null) {
			disciplinas = DisciplinaBO.listDisciplina();
		}
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplina) {
		this.disciplinas = disciplina;
	}

	public List<Escola> getEscolas() {
		if (!escolas.isEmpty()) {
			escolas = EscolaBO.listEscola();
		}
		return escolas;
	}

	public void setEscolas(List<Escola> escolas) {
		this.escolas = escolas;
	}

	public List<Professor> getProfessores() {
		if (professores == null) {
			professores = ProfessorBO.listarProfessor();
		}
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public List<Aluno> getAlunos() {
		if (alunos == null) {
			alunos = AlunoBO.listarALunos();
		}
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Turno> getTurnos() {
		turnos = TurnoBo.getTurnos();
		return turnos;
	}

	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}
	
	

	public List<Prova> getProvas() {
		provas = ProvaBO.getProvas();
		return provas;
	}

	public void setProvas(List<Prova> provas) {
		this.provas = provas;
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edição Cancelada",
				(((Turma) event.getObject()).getNumsala()));
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowEdit(RowEditEvent event) {
		try {
			FacesMessage msg = new FacesMessage("Turma Editada",
					(((Turma) event.getObject()).getNumsala()));
			FacesContext.getCurrentInstance().addMessage(null, msg);
			TurmaBO.update(event.getObject());
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage("Error", e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	
	public void pdf(ActionEvent event) {
		
	}

	public void postProcessXLS(Object document) {
		HSSFWorkbook wb = (HSSFWorkbook) document;
		HSSFSheet sheet = wb.getSheetAt(0);
		CellStyle style = wb.createCellStyle();
		style.setFillBackgroundColor(IndexedColors.AQUA.getIndex());

		for (Row row : sheet) {
			for (Cell cell : row) {
				cell.setCellValue(cell.getStringCellValue().toUpperCase());
				cell.setCellStyle(style);
			}
		}
	}

	public List<Prova> getFilteredProvas() {
		return filteredProvas;
	}

	public void setFilteredProvas(List<Prova> filteredProvas) {
		this.filteredProvas = filteredProvas;
	}
	
	

}
