package com.qyf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qyf.model.Solicitud;

@Repository
public interface ISolicitud extends JpaRepository<Solicitud, Integer> {
	
	@Query("SELECT s FROM Solicitud")
	public List<Solicitud> findAll(String key);
}
