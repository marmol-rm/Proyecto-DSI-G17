package com.qyf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qyf.interfaceService.IMateriaImpServ;
import com.qyf.model.Materia_Imp;
import com.qyf.repository.IMateriaImp;

@Service
public class MateriaImpServ implements IMateriaImpServ{
	@Autowired
	private IMateriaImp data;
	
	@Override
	public List<Materia_Imp> listar(String key) {
		long n = data.count();
			if(key!=null)
				return data.findAll(key);
			else
				return data.findAll();
	}

	@Override
	public Optional<Materia_Imp> listarId(int id) {
		
		return data.findById(id);
	}

	@Override
	public int guardar(Materia_Imp materia) {
		Materia_Imp m = data.save(materia);
		/*Materia_Imp m = new Materia_Imp();
		if(materia.getPass() == materia.getTemp_pass()) {
			materia.setPass(materia.getTemp_pass());
			materia.setTemp_pass("");
			m = data.save(materia);
		}*/
		int res=0;
		if(!m.equals(null)) {
			res = 1;
		}
		
		return res;
	}

	@Override
	public void eliminar(int id) {
		data.deleteById(id);
	}
}
