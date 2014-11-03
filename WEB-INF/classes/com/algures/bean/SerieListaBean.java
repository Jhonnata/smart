package com.algures.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.algures.bo.SerieBO;
import com.algures.model.Serie;

@ManagedBean
@RequestScoped
public class SerieListaBean {

	private Serie serie;
	private List<Serie> series;

	public SerieListaBean() {
	}

	public Serie getSerie() {
		return serie;
	}
	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public List<Serie> getSeries() {
		if (this.series == null) {
			this.series = SerieBO.getSeries();
		}
		return this.series;
	}
	public void setSeries(List<Serie> series) {
		this.series = series;
	}

}
