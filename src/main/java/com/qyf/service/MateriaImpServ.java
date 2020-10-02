package com.qyf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qyf.interfaceService.IMateriaImpServ;
import com.qyf.interfaces.IMateriaImp;
import com.qyf.model.Materia_Imp;

@Service
public class MateriaImpServ implements IMateriaImpServ{
	@Autowired
	private IMateriaImp data;
	
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
		Materia_Imp mat = data.save(materia);
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
