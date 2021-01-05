package com.qyf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qyf.model.Evaluacion;

@Repository
public interface IEvaluacion extends JpaRepository<Evaluacion, Integer> {
	@Query("SELECT e FROM Evaluacion e WHERE " +
			"CONCAT(e.evaluacion, e.fecha) LIKE %?1%")
	public List<Evaluacion> findAll(String key);
}
