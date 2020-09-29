package com.qyf.interfaces;

import java.util.List;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.qyf.model.Departamento;

@Repository
public interface IDepartamento extends CrudRepository<Departamento, Integer>{
	
	@Query("SELECT d FROM Departamento d WHERE "+
	"CONCAT(d.id, d.nombre_departamento) LIKE %?1%")
	public List<Departamento> findAll(String key);
}
