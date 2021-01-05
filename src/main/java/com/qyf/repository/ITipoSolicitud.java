package com.qyf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qyf.model.Tipo_Solicitud;

@Repository
public interface ITipoSolicitud extends JpaRepository<Tipo_Solicitud, Integer> {

}
