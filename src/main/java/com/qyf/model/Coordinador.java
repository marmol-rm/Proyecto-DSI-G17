package com.qyf.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="coordinador_catedra")
public class Coordinador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true)
	private int id_catedra;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_docente")
	private Docente docente;
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="id_materia_imp")
	private List<Materia_Imp> materias;
	
	public Coordinador() {
		super();
	}

	public int getId_catedra() {
		return id_catedra;
	}

	public void setId_catedra(int id_catedra) {
		this.id_catedra = id_catedra;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public List<Materia_Imp> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia_Imp> materias) {
		this.materias = materias;
	}
}
