package com.qyf.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.SessionAttribute;

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
	public int guardar(Departamento d) {
		int res=0;
		Departamento depto = data.save(d);
		if(!depto.equals(null)) {
			res = 1;
		}
		return res;
	}
	
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		data.deleteById(id);
	}

}
