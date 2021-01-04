package com.qyf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qyf.model.Estudiante;

@Repository
public interface IEstudiante extends JpaRepository<Estudiante, Integer> {

}
