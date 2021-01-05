package com.qyf.interfaceService;

import java.util.List;

import com.qyf.model.Docente;
import com.qyf.model.Usuario;

public interface IDocenteServ {
	public List<Docente> listar();
	public Docente listarUsuario(Usuario user);
	public int guardar(Docente docente);
	public void eliminar(int id);
}
