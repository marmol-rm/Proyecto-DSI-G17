package com.qyf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qyf.model.Departamento;

@Repository
public interface IDepartamento extends JpaRepository<Departamento, Integer> {
	@Query("SELECT d FROM Departamento d WHERE "+
	"CONCAT(d.id_depto, d.departamento, d.jefe) LIKE %?1%")
	public List<Departamento> findAll(String key);
}
