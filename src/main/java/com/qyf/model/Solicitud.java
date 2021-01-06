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
	@Column(length = 1)
	private int estado;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_evaluacion")
	private Evaluacion evaluacion;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tipo")
	private Tipo_Solicitud tipo;
	
	public Solicitud() {
		super();
	}
	
	public String getEstadoSol() {
		String estado = "";
		switch(this.estado) {
			case 0:
				estado = "Pendiente";
			break;
			case 1:
				estado = "Aceptada";
			break;
			case 2:
				estado = "Denegada";
			break;
		}
		
		return estado;
	}

	public Integer getId_solicitud() {
		return id_solicitud;
	}

	public void setId_solicitud(Integer id_solicitud) {
		this.id_solicitud = id_solicitud;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
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

	public Tipo_Solicitud getTipo() {
		return tipo;
	}

	public void setTipo(Tipo_Solicitud tipo) {
		this.tipo = tipo;
	}
}
