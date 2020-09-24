package com.qyf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="docente")
public class Docente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_docente;
	private Integer id_user;
}
