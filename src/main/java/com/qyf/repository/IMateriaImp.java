package com.qyf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qyf.model.Materia_Imp;

@Repository
public interface IMateriaImp extends JpaRepository<Materia_Imp, Integer>{
	@Query("SELECT m FROM Materia_Imp m WHERE "+
	"CONCAT(m.materia.codigo,m.materia.nombre_materia,"+
	"m.coordinador.docente.user.nombres,"+
	"m.coordinador.docente.user.apellidos) LIKE %?1%")
	public List<Materia_Imp> findAll(String key);
}
