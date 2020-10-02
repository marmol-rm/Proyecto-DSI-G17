package com.qyf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="ciclo")
public class Ciclo {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(unique=true)
	private int id_ciclo;
	@Column(length=255)
	private String titulo;
	private int numero;
	private int anio;
	private int activo;
	private String fecha_ini;
	private String fecha_fin;
}
