package com.qyf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="jefes_depto")
public class Jefes_Depto {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(unique=true)
	private int id_jefe;
	@ManyToOne(fetch = FetchType.EAGER)
	private Departamento dep;
	@ManyToOne(fetch = FetchType.EAGER)
	private Docente doc;
}
