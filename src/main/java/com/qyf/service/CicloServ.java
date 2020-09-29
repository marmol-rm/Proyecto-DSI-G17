package com.qyf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qyf.interfaceService.ICicloServ;
import com.qyf.interfaces.ICiclo;
import com.qyf.model.Ciclo;

@Service
public class CicloServ implements ICicloServ {
	@Autowired
	private ICiclo data;

	@Override
	public List<Ciclo> listar(String key) {
		if(key!=null) {
			return (List<Ciclo>) data.findAll(key);
		}
		else
		return (List<Ciclo>) data.findAll();
	}
	
	@Override
	public Optional<Ciclo> listarId(int id) {
		return data.findById(id);
	}
	
	@Override
	public int guardar(Ciclo c) {
		int res=0;
		Ciclo ciclo = data.save(c);
		if(!ciclo.equals(null)) {
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
