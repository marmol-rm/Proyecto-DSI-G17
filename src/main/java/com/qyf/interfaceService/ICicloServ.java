package com.qyf.interfaceService;

import java.util.List;
import java.util.Optional;

import com.qyf.model.Ciclo;

public interface ICicloServ {
	public List<Ciclo> listar(String key);
	public Optional<Ciclo> listarId(int id);
	public int guardar(Ciclo ciclo);
	public void delete(int id);
}
