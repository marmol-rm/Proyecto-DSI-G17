package com.qyf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qyf.interfaceService.IEstudianteServ;
import com.qyf.model.Estudiante;
import com.qyf.repository.IEstudiante;

@Service
public class EstudianteServ implements IEstudianteServ {
	@Autowired
	private IEstudiante data;

	@Override
	public List<Estudiante> listar() {
		
		return data.findAll();
	}

	@Override
	public int guardar(Estudiante estudiante) {
		Estudiante e = data.save(estudiante);
		 int res = 0;
		 if(!e.equals(null))
			 res = 1;
		
		return res;
	}

	@Override
	public void eliminar(int id) {
		data.deleteById(id);
	}

}
