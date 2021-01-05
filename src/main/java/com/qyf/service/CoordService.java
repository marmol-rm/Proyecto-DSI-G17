package com.qyf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qyf.interfaceService.ICoordinadorServ;
import com.qyf.model.Coordinador;
import com.qyf.model.Docente;
import com.qyf.repository.ICoordinador;

@Service
public class CoordService implements ICoordinadorServ {
	
	@Autowired
	private ICoordinador data;
	
	@Override
	public List<Coordinador> listar() {
		
		return data.findAll();
	}

	@Override
	public Coordinador listarUsuario(Docente d) {
		
		return data.findByDocente(d);
	}
	
	@Override
	public int guardar(Coordinador c) {
		int res = 0;
		Coordinador co = data.save(c);
		if(!co.equals(null))
			res =1 ;
		
		return res;
	}

	@Override
	public void eliminar(int id) {
		data.deleteById(id);
	}
}
