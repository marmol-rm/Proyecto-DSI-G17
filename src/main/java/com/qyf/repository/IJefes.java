package com.qyf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qyf.model.Docente;
import com.qyf.model.Jefes_Depto;

public interface IJefes extends JpaRepository<Jefes_Depto, Integer>{
	
	public Jefes_Depto findByDocente(Docente d);
}
