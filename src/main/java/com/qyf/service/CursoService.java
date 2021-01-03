package com.qyf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qyf.interfaceService.ICursoServ;
import com.qyf.model.Curso;
import com.qyf.repository.ICurso;

@Service
public class CursoService implements ICursoServ{
	
	@Autowired
	private ICurso data;
	
	@Override
	public List<Curso> listar(String key) {
		if(key!=null)
			return (List<Curso>) data.findAll(key);
		else
			return (List<Curso>) data.findAll();
	}

	@Override
	public Optional<Curso> listarId(int id) {
		
		return data.findById(id);
	}

	@Override
	public int guardar(Curso curso) {
		int res = 0;
		Curso c = new Curso();
		if(curso.getPass() != curso.getTemp_pass()) { //Valida si la contrasena es diferente
			curso.setTemp_pass("");
			c = data.save(curso);
		}
		else
			c = data.save(curso);
		if(!c.equals(null))
			res = 1;
		
		return res;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		data.deleteById(id);
	}

}
