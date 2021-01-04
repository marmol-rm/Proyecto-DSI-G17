package com.qyf.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="coordinador")
public class Coordinador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true)
	private int id_catedra;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@JoinColumn(name="id_docente", unique=true)
	private Docente docente;
	
	public Coordinador() {
		super();
	}
	
	public String getNombre_completo() {
		String nombre = this.getDocente().getUser().getNombre_completo();
		if(nombre != null) {
			return nombre;
		}
		else {
			nombre = "";
			return nombre;
		}
	}

	public int getId_catedra() {
		return id_catedra;
	}

	public void setId_catedra(int id_catedra) {
		this.id_catedra = id_catedra;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}
}
