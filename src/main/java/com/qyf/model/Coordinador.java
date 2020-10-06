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

import lombok.Data;

@Data
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
}
