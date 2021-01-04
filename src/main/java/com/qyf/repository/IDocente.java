package com.qyf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qyf.model.Docente;

@Repository
public interface IDocente extends JpaRepository<Docente, Integer> {

}
