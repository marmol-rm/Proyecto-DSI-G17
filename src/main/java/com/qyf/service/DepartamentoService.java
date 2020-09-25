package com.qyf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qyf.interfaceService.IDepartamentoServ;
import com.qyf.interfaces.IDepartamento;
import com.qyf.model.Departamento;

@Service
public class DepartamentoService implements IDepartamentoServ{
	@Autowired
	private IDepartamento data;
	@Override
	public List<Departamento> listar() {
		return (List<Departamento>) data.findAll();
	}

}
