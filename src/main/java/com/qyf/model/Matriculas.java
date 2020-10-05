package com.qyf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="matriculas")
public class Matriculas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true)
	private long id_matricula;
	@ManyToOne(fetch = FetchType.EAGER)
	private Estudiante e;
	@ManyToOne(fetch = FetchType.EAGER)
	private Materia_Imp m;
}
