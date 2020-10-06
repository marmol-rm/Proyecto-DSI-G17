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
@Table(name="materia")
public class Materia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true)
	private int id_materia;
	@Column(length=6, unique=true)
	private String codigo;
	@Column(length=255)
	private String nombre_materia;
	@Column(name="TIPO")
	private String tipo;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_depto")
	private Departamento departamento;
}
