package com.qyf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(unique=true)
	private int id_rol;
	@Column(length=255)
	private String nombre;
	@Column(length=255)
	private String descripcion;
}
