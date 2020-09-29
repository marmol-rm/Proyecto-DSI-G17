package com.qyf.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ciclo")
public class Ciclo {
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="ID_CICLO")
	private int id;
	@Column(name="TITULO")
	private String titulo;
	@Column(name="NUMERO")
	private int numero;
	@Column(name="ACTIVO")
	private Boolean activo;
	@Column(name="FECHA_INI")
	private Date fecha_inicio;
	@Column(name="FECHA_FIN")
	private Date fecha_final;
	
	public Ciclo() {
		super();
	}
	
	public Ciclo(int id, String titulo, int num, Boolean activo, Date fecha_inicio, Date fecha_final) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.numero = num;
		this.activo = activo;
		this.fecha_inicio = fecha_inicio;
		this.fecha_final = fecha_final;
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

	public int getNum() {
		return numero;
	}

	public void setNum(int num) {
		this.numero = num;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Date getFechaInicio() {
		return fecha_inicio;
	}

	public void setFechaInicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFechaFinal() {
		return fecha_final;
	}

	public void setFechaFinal(Date fecha_final) {
		this.fecha_final = fecha_final;
	}
}
