package com.qyf.model;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true)
	private int id_curso;
	@Column(length = 255)
	private String pass;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_materia_imp")
	private Materia_Imp materia;
	
	public Curso() {
		super();
	}

}
