package com.qyf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_solicitud")
public class Tipo_Solicitud {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true)
	private int id_tipo_sol;
	@Column(unique = true)
	private int tipo_solicitud;
	@Column(length = 255)
	private String descripcion;
	
	public Tipo_Solicitud() {
		super();
	}

	public Tipo_Solicitud(int tipo_solicitud, String descripcion) {
		super();
		this.tipo_solicitud = tipo_solicitud;
		this.descripcion = descripcion;
	}

	public int getId_tipo_sol() {
		return id_tipo_sol;
	}

	public void setId_tipo_sol(int id_tipo_sol) {
		this.id_tipo_sol = id_tipo_sol;
	}

	public int getTipo_solicitud() {
		return tipo_solicitud;
	}

	public void setTipo_solicitud(int tipo_solicitud) {
		this.tipo_solicitud = tipo_solicitud;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
