package com.qyf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qyf.model.Coordinador;

@Repository
public interface ICoordinador extends JpaRepository<Coordinador, Integer> {
	
	@Query("SELECT c FROM Coordinador c")
	public List<Coordinador> findAll();
}
