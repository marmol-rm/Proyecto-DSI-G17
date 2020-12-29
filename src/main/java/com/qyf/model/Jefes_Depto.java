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
	@JoinColumn(name="id_docente")
	private Docente docente;
	
	public Jefes_Depto() {
		super();
	}
	
	public String getNombreJefe() {
		String nombre = this.getDocente().getUser().getNombre_completo();
		if (nombre != null){
			return nombre;
		}
		else {
			nombre = "";
			return nombre;
		}
	}

	public int getId_jefe() {
		return id_jefe;
	}

	public void setId_jefe(int id_jefe) {
		this.id_jefe = id_jefe;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}
}
