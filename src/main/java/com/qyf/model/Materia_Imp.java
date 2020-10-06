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

import lombok.Data;

@Data
@Entity
@Table(name="materias_impartidas")
public class Materia_Imp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true)
	private int id_materia_imp;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_materia")
	private Materia materia;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_ciclo")
	private Ciclo ciclo;
}
