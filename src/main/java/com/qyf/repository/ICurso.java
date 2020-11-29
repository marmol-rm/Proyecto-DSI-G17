package com.qyf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qyf.model.Curso;

@Repository
public interface ICurso extends JpaRepository<Curso, Integer>{
	
	@Query("SELECT c FROM Curso c WHERE c.id_curso LIKE %?1%")
	public List<Curso> findAll(String key);
}
