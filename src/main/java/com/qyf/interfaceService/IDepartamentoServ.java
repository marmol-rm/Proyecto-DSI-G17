package com.qyf.interfaceService;

import java.util.List;
import java.util.Optional;

import com.qyf.model.Departamento;
import com.qyf.model.Jefes_Depto;

public interface IDepartamentoServ {
	public List<Departamento> listar(String key);
	public List<Jefes_Depto> listarJefes();
	public Optional<Departamento> listarId(int id);
	public int guardar(Departamento depto);
	public void delete(int id);
}
