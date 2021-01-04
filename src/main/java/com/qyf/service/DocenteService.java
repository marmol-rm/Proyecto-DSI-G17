package com.qyf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qyf.interfaceService.IDocenteServ;
import com.qyf.model.Docente;
import com.qyf.repository.IDocente;

@Service
public class DocenteService implements IDocenteServ {
	@Autowired
	private IDocente data;

	@Override
	public int guardar(Docente docente) {
		int res = 0;
		Docente d = data.save(docente);
		if(!d.equals(null))
			res = 1;
		
		return res;
	}

	@Override
	public void eliminar(int id) {
		data.deleteById(id);
	}

}
