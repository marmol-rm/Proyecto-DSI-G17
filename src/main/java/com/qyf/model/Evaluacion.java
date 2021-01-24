package com.qyf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "evaluacion")
public class Evaluacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true)
	private int id_evaluacion;
	@Column(length = 20)
	private String fecha;
	@Column(length = 255)
	private String evaluacion;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_materia_imp")
	private Materia_Imp materia;
	
	public Evaluacion() {
		super();
	}
	
	public String getEv() {
		return this.evaluacion + " - " + this.materia.getMateria().getNombre_materia();
	}

	public int getId_evaluacion() {
		return id_evaluacion;
	}

	public void setId_evaluacion(int id_evaluacion) {
		this.id_evaluacion = id_evaluacion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(String evaluacion) {
		this.evaluacion = evaluacion;
	}

	public Materia_Imp getMateria() {
		return materia;
	}

	public void setMateria(Materia_Imp materia) {
		this.materia = materia;
	}
}
