package com.qyf.service;

import java.util.List;
import java.util.Optional;

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
	@Override
	public Optional<Departamento> listarId(int id) {
		return data.findById(id);
	}
	@Override
	public int save(Departamento depto) {
		// TODO Auto-generated method stub
		int res=0;
		Departamento d = data.save(depto);
				if(!d.equals(null)) {
					res = 1;
				}
		return res;
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
