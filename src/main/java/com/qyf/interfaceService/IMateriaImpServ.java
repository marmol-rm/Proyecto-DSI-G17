package com.qyf.interfaceService;

import java.util.List;
import java.util.Optional;

import com.qyf.model.Materia_Imp;

public interface IMateriaImpServ {
	public List<Materia_Imp> listar(String key);
	public Optional<Materia_Imp> listarId(int id);
	public int guardar(Materia_Imp materia);
	public void delete(int id);
}
