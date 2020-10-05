package com.qyf.model;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="coordinador_catedra")
public class Coordinador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true)
	private int id_catedra;
	@ManyToOne(fetch = FetchType.EAGER)
	private Docente docente;
	@ManyToOne(fetch = FetchType.EAGER)
	private Materia_Imp materia;
}
