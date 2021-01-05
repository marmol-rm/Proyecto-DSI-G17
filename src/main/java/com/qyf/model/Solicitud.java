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
	private Integer id_solicitud;
	@Column(length = 10)
	private String fecha_solicitud;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_evaluacion")
	private Evaluacion evaluacion;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tipo_sol")
	private int tipo_solicitud;
	
	public Solicitud() {
		super();
	}

	public Integer getId_solicitud() {
		return id_solicitud;
	}

	public void setId_solicitud(Integer id_solicitud) {
		this.id_solicitud = id_solicitud;
	}

	public Evaluacion getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(Evaluacion evaluacion) {
		this.evaluacion = evaluacion;
	}

	public String getFecha_solicitud() {
		return fecha_solicitud;
	}

	public void setFecha_solicitud(String fecha_solicitud) {
		this.fecha_solicitud = fecha_solicitud;
	}

	public int getTipo_solicitud() {
		return tipo_solicitud;
	}

	public void setTipo_solicitud(int tipo_solicitud) {
		this.tipo_solicitud = tipo_solicitud;
	}
}
