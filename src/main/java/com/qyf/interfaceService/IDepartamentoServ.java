package com.qyf.interfaceService;

import java.util.List;
import java.util.Optional;

import com.qyf.model.Departamento;

public interface IDepartamentoServ {
	public List<Departamento> listar();
	public Optional<Departamento> listarId(int id);
	public int save(Departamento depto);
	public void delete(int id);
}
