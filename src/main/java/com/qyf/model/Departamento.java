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
	private Integer id;
	@Column(name="DEPARTAMENTO", length = 255)
	private String departamento;
	
	public Departamento() {
		super();
	}

	public Departamento(Integer id, String departamento) {
		super();
		this.id = id;
		this.departamento = departamento;
	}

	public Integer getId_depto() {
		return id;
	}

	public void setId_depto(Integer id_depto) {
		this.id = id_depto;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
}
