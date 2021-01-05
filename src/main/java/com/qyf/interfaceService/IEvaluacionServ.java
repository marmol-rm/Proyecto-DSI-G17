package com.qyf.interfaceService;

import java.util.List;
import java.util.Optional;

import com.qyf.model.Evaluacion;

public interface IEvaluacionServ {
	public List<Evaluacion> listar(String key);
	public Optional<Evaluacion> listaId(int id);
	public int guardar(Evaluacion e);
	public void eliminar(int id);
}
