package com.qyf.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qyf.model.Materia;

@Repository
public interface IMateria extends JpaRepository<Materia, Integer>{
	@Query("SELECT m FROM Materia m WHERE "+
	"CONCAT(m.id_materia, m.codigo, m.nombre_materia, m.tipo) LIKE %?1%")
	public List<Materia> findAll(String key);
}
