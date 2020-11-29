package com.qyf.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Tipo_Solicitud {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true)
	private int id_tipo_sol;
	@Column(length = 255)
	private int tipo_solicitud;
	
	public Tipo_Solicitud() {
		super();
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
}
