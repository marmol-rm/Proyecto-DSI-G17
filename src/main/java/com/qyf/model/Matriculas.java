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
@Table(name="matriculas")
public class Matriculas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true)
	private Long id_matricula;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="carnet")
	private Estudiante estudiante;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_materia_imp")
	private Materia_Imp materia;
}
