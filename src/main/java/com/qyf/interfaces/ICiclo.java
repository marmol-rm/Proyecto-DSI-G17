package com.qyf.interfaces;

import java.util.List;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.qyf.model.Ciclo;

@Repository
public interface ICiclo extends CrudRepository<Ciclo, Integer>{
	
	@Query("SELECT c FROM Ciclo c WHERE "+
	"CONCAT(c.id, c.titulo, c.numero, c.fecha_inicio, c.fecha_final, c.activo) LIKE %?1%")
	public List<Ciclo> findAll(String key);
}
