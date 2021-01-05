package com.qyf.interfaceService;

import java.util.List;

import com.qyf.model.Estudiante;
import com.qyf.model.Usuario;

public interface IEstudianteServ {
	public List<Estudiante> listar();
	public Estudiante listarUsuario(Usuario user);
	public int guardar(Estudiante estudiante);
	public void eliminar(int id);
}
