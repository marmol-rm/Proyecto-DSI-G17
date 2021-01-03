package com.qyf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qyf.interfaceService.IEvaluacoinServ;
import com.qyf.model.Evaluacion;
import com.qyf.repository.IEvaluacion;

@Service
public class EvaluacionServ implements IEvaluacoinServ {
	@Autowired
	private IEvaluacion data;
	
	@Override
	public List<Evaluacion> listar() {

		return (List<Evaluacion>) data.findAll();
	}

	@Override
	public Optional<Evaluacion> listaId(int id) {
		
		return data.findById(id);
	}

	@Override
	public int guardar(Evaluacion e) {
		int res = 0;
		Evaluacion ev = data.save(e);
		if(!ev.equals(null))
			res = 1;
		
		return res;
	}

	@Override
	public void eliminar(int id) {
		data.deleteById(id);
	}

}
