package com.qyf.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

@Entity
@Table(name="ciclo")
public class Ciclo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true)
	private int id_ciclo;
	@Column(length=255)
	private String titulo;
	@Nullable
	@OneToMany(mappedBy = "id_materia_imp", cascade = CascadeType.REMOVE)
	private List<Materia_Imp> materias_impartidas;
	private int numero;
	private int anio;
	private Integer activo;
	private String fecha_ini;
	private String fecha_fin;
	
	public Ciclo() {
		super();
	}
	
	public String getEstado() {
		String estado;
		if(this.getActivo()==0)
			estado = "INACTIVO";
		else
			estado = "ACTIVO";
		return estado;
	}

	public int getId_ciclo() {
		return id_ciclo;
	}

	public void setId_ciclo(int id_ciclo) {
		this.id_ciclo = id_ciclo;
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

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public Integer getActivo() {
		return activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}

	public String getFecha_ini() {
		return fecha_ini;
	}

	public void setFecha_ini(String fecha_ini) {
		this.fecha_ini = fecha_ini;
	}

	public String getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
}
