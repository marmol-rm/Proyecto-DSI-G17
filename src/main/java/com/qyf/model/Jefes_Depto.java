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
@Table(name="jefes_depto")
public class Jefes_Depto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true)
	private int id_jefe;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_depto")
	private Departamento departamento;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_docente")
	private Docente docente;
}
