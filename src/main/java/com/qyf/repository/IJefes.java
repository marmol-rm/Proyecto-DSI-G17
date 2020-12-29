package com.qyf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qyf.model.Jefes_Depto;

public interface IJefes extends JpaRepository<Jefes_Depto, Integer>{
	
	@Query("SELECT j from Jefes_Depto j")
	public List<Jefes_Depto> findAll();
}
