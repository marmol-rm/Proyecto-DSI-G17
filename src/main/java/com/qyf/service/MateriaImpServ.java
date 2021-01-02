package com.qyf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qyf.interfaceService.IMateriaImpServ;
import com.qyf.model.Curso;
import com.qyf.model.Materia_Imp;
import com.qyf.repository.ICurso;
import com.qyf.repository.IMateriaImp;

@Service
public class MateriaImpServ implements IMateriaImpServ{
	@Autowired
	private IMateriaImp data;
	@Autowired
	private ICurso data_cursos;
	
	@Override
	public List<Materia_Imp> listar(String key) {
		if(key!=null) {
			return (List<Materia_Imp>)data.findAll(key);
		}
		else
		return (List<Materia_Imp>) data.findAll();
	}

	@Override
	public Optional<Materia_Imp> listarId(int id) {
			return data.findById(id);
	}

	@Override
	public int guardar(Materia_Imp materia) {
		int res=0;
		Curso c = new Curso();
		c.setId_curso(materia.getId_materia_imp()); //Le asigna el mismo id
		data_cursos.save(c); //crea el curso antes de guardar la materia
		materia.setCurso(c);
		Materia_Imp m = data.save(materia);
		if(!m.equals(null)) {
			res = 1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
	}
}
