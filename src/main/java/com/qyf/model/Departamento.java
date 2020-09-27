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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_DEPTO")
	private int id;
	@Column(name="DEPARTAMENTO", length = 255)
	private String departamento;
	
	public Departamento() {
		super();
	}

	public Departamento(int id, String departamento) {
		super();
		this.id = id;
		this.departamento = departamento;
	}

	public int getId_depto() {
		return id;
	}

	public void setId_depto(int id_depto) {
		this.id = id_depto;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
}
