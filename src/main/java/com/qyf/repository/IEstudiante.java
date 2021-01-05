package com.qyf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qyf.model.Estudiante;
import com.qyf.model.Usuario;

@Repository
public interface IEstudiante extends JpaRepository<Estudiante, Integer> {
	
	public Estudiante findByUser(Usuario user);
}
