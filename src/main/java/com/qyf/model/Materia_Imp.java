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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="materias_impartidas")
public class Materia_Imp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true)
	private int id_materia_imp;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_materia", unique=true)
	private Materia materia;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_ciclo")
	private Ciclo ciclo;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_catedra")
	private Coordinador coordinador;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@JoinColumn(unique = true)
	private Curso curso;
	
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Materia_Imp() {
		super();
	}

	public int getId_materia_imp() {
		return id_materia_imp;
	}

	public void setId_materia_imp(int id_materia_imp) {
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
