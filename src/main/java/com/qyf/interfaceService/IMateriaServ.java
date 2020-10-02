package com.qyf.interfaceService;

import java.util.List;
import java.util.Optional;

import com.qyf.model.Materia;

public interface IMateriaServ {
	public List<Materia> listar(String key);
	public Optional<Materia> listarId(int id);
	public int guardar(Materia materia);
	public void delete(int id);
}
