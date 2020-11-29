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
@Table(name = "solicitud")
public class Solicitud {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true)
	private int id_solicitud;
	@Column(length = 10)
	private String fecha_solicitud;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_evaluacion")
	private Evaluacion evaluacion;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tipo_sol")
	private Tipo_Solicitud tipo;
	
	public Solicitud() {
		super();
	}

	public int getId_solicitud() {
		return id_solicitud;
	}

	public void setId_solicitud(int id_solicitud) {
		this.id_solicitud = id_solicitud;
	}

	public Evaluacion getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(Evaluacion evaluacion) {
		this.evaluacion = evaluacion;
	}

	public Tipo_Solicitud getTipo() {
		return tipo;
	}

	public void setTipo(Tipo_Solicitud tipo) {
		this.tipo = tipo;
	}
}
