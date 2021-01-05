package com.qyf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qyf.interfaceService.IMateriaServ;
import com.qyf.model.Materia;
import com.qyf.repository.IMateria;

@Service
public class MateriaServ implements IMateriaServ{
	@Autowired
	private IMateria data;
	
	@Override
	public List<Materia> listar(String key) {
		if(key!=null)
			return data.findAll(key);
		else
			return data.findAll();
	}

	@Override
	public Optional<Materia> listarId(int id) {
			return data.findById(id);
	}

	@Override
	public int guardar(Materia materia) {
		int res=0;
		Materia mat = data.save(materia);
		if(!mat.equals(null)) {
			res = 1;
		}
		
		return res;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
	}
}
