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
	public int crear() {
		Curso curso = new Curso(0,"","");
		data.save(curso);
		
		return 0;
	}

	@Override
	public int guardar(Curso curso) {
		int res = 0;
		Curso c = data.save(curso);
		
		if(!c.equals(null))
			res = 1;
		
		return res;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
	}
}
