package com.qyf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "curso")
public class Curso {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true)
	private Integer id_curso;
	@Column(length = 255)
	private String pass;
	@Column(length = 255)
	private String temp_pass;
	
	public Curso() {
		super();
	}

	public Integer getId_curso() {
		return id_curso;
	}

	public void setId_curso(Integer id_curso) {
		this.id_curso = id_curso;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getTemp_pass() {
		return temp_pass;
	}

	public void setTemp_pass(String temp_pass) {
		this.temp_pass = temp_pass;
	}
}
