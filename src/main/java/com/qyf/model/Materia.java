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
@Table(name="materia")
public class Materia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true)
	private int id_materia;
	@Column(length=6, unique=true)
	private String codigo;
	@Column(length=255)
	private String nombre_materia;
	@Column(name="tipo")
	private String tipo;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_depto")
	private Departamento departamento;
	
	public Materia() {
		super();
	}

	public int getId_materia() {
		return id_materia;
	}

	public void setId_materia(int id_materia) {
		this.id_materia = id_materia;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre_materia() {
		return nombre_materia;
	}

	public void setNombre_materia(String nombre_materia) {
		this.nombre_materia = nombre_materia;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
}
