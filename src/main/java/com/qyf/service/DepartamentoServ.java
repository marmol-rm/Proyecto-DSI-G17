package com.qyf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qyf.interfaceService.IDepartamentoServ;
import com.qyf.model.Departamento;
import com.qyf.repository.IDepartamento;

@Service
public class DepartamentoServ implements IDepartamentoServ{
	
	@Autowired
	private IDepartamento data;
	
	@Override
	public List<Departamento> listar(String key) {
		if(key != null) {
			return data.findAll(key);
		}
		else
			return data.findAll();
	}
	
	@Override
	public Optional<Departamento> listarId(int id) {
		return data.findById(id);
	}
	
	@Override
	public int guardar(Departamento d) {
		int res=0;
		Departamento depto = data.save(d);
		if(!depto.equals(null))
			res = 1;

		return res;
	}
	
	@Override
	public void delete(int id) {
		data.deleteById(id);
	}
}
