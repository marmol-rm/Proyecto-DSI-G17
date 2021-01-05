package com.qyf.interfaceService;

import java.util.List;

import com.qyf.model.Coordinador;
import com.qyf.model.Docente;

public interface ICoordinadorServ {
	public List<Coordinador> listar();
	public Coordinador listarUsuario(Docente d);
	public int guardar(Coordinador c);
	public void eliminar(int id);
}
