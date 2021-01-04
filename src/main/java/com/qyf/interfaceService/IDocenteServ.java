package com.qyf.interfaceService;

import com.qyf.model.Docente;

public interface IDocenteServ {
	public int guardar(Docente docente);
	public void eliminar(int id);
}
