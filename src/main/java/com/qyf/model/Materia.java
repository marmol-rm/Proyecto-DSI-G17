package com.qyf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="materia")
public class Materia {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_materia;
	private Integer id_depto;
}