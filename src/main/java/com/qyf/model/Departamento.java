package com.qyf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

@Entity
@Table(name="departamento")
public class Departamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true)
	private int id_depto;
	@Column(length=255)
	private String departamento;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_jefe")
	private Jefes_Depto jefe;
	
	public Departamento() {
		super();
	}

	public int getId_depto() {
		return id_depto;
	}

	public void setId_depto(int id_depto) {
		this.id_depto = id_depto;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	public Jefes_Depto getJefe() {
		return jefe;
	}

	public void setJefe(Jefes_Depto jefe) {
		this.jefe = jefe;
	}
}
