package com.qyf.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.qyf.model.Departamento;

@Repository
public interface IDepartamento extends CrudRepository<Departamento, Integer>{

}
