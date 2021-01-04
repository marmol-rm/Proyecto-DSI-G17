package com.qyf.interfaceService;

import java.util.List;

import com.qyf.model.Estudiante;

public interface IEstudianteServ {
	public List<Estudiante> listar();
	public int guardar(Estudiante estudiante);
	public void eliminar(int id);
}
