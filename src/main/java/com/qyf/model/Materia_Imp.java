package com.qyf.model;

import javax.persistence.CascadeType;
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
@Table(name="materias_impartidas")
public class Materia_Imp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true)
	private Integer id_materia_imp;
	@Column(length = 25)
	private String pass;
	@Column(length = 25)
	private String temp_pass;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_materia", unique=true)
	private Materia materia;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_ciclo")
	private Ciclo ciclo;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_catedra")
	private Coordinador coordinador;
	
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getTemp_pass() {
		return temp_pass;
	}

	public void setTemp_pass(String temp_pass) {
		this.temp_pass = temp_pass;
	}

	public Materia_Imp() {
		super();
	}

	public Integer getId_materia_imp() {
		return id_materia_imp;
	}

	public void setId_materia_imp(Integer id_materia_imp) {
		this.id_materia_imp = id_materia_imp;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Ciclo getCiclo() {
		return ciclo;
	}

	public void setCiclo(Ciclo ciclo) {
		this.ciclo = ciclo;
	}

	public Coordinador getCoordinador() {
		return coordinador;
	}

	public void setCoordinador(Coordinador coord) {
		this.coordinador = coord;
	}
}
