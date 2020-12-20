package com.qyf.interfaceService;

import java.util.List;
import java.util.Optional;

import com.qyf.model.Departamento;

public interface IDepartamentoServ {
	public List<Departamento> listar(String key);
	public Optional<Departamento> listarId(int id);
	public int guardar(Departamento depto);
	public void delete(int id);
}
