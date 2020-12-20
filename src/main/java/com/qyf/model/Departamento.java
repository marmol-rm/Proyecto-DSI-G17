package com.qyf.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="departamento")
public class Departamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true)
	private int id_depto;
	@Column(length=255)
	private String departamento;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_jefe")
	private List<Jefes_Depto> jefes;
	
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

	public List<Jefes_Depto> getJefes() {
		return jefes;
	}

	public void setJefes(List<Jefes_Depto> jefes) {
		this.jefes = jefes;
	}
}
