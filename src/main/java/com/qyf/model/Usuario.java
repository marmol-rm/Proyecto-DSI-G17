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
@Table(name="user")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(unique=true)
	private int id_user;
	@Column(length=255)
	private String nombres;
	@Column(length=255)
	private String apellidos;
	@Column(length=255)
	private String email;
	@Column(length=255)
	private String password;
	private int activo;

	@ManyToOne(fetch = FetchType.EAGER)
	private Role r;
}
