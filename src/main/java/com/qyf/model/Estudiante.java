package com.qyf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estudiante")
public class Estudiante {
	@Id
	@Column(name="CARNET")
	private String carnet;
	@Column(name="ID_USER")
	private Integer id_user;
}
