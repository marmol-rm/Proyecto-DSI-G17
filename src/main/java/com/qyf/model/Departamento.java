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
	@Column(unique=true)
	private int id_depto;
	@Column(length=255)
	private String departamento;
	
	public Departamento() {
		super();
	}

	public int getId_depto() {
		return id_depto;
	}

	public void setId_depto(int id_depto) {
		this.id_depto = id_depto;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
}
