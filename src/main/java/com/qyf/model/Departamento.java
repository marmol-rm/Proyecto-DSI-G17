package com.qyf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="departamento")
public class Departamento {
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="ID_DEPTO")
	private int id;
	@Column(name="DEPARTAMENTO")
	private String nombre_departamento;
	
	public Departamento() {
		super();
	}

	public Departamento(int id, String departamento) {
		super();
		this.id = id;
		this.nombre_departamento = departamento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartamento() {
		return nombre_departamento;
	}

	public void setDepartamento(String departamento) {
		this.nombre_departamento = departamento;
	}
}
