package com.qyf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ciclo")
public class Ciclo {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="ID_CICLO")
	private int id;
	@Column(name="TITULO")
	private String titulo;
	@Column(name="NUMERO")
	private int numero;
	@Column(name="ANIO")
	private int anio;
	@Column(name="ACTIVO")
	private String activo;
	@Column(name="FECHA_INI")
	private String fechaInicio;
	@Column(name="FECHA_FIN")
	private String fechaFinal;
	
	public Ciclo() {
		super();
	}
	
	public Ciclo(int id, String titulo, int num, String activo, String fecha_inicio, String fecha_final) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.numero = num;
		this.activo = activo;
		this.fechaInicio = fecha_inicio;
		this.fechaFinal = fecha_final;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int num) {
		this.numero = num;
	}
	
	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fecha_inicio) {
		this.fechaInicio = fecha_inicio;
	}

	public String getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(String fecha_final) {
		this.fechaFinal = fecha_final;
	}
}
