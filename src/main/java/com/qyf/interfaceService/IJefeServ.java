package com.qyf.interfaceService;

import java.util.List;

import com.qyf.model.Docente;
import com.qyf.model.Jefes_Depto;

public interface IJefeServ {
	public List<Jefes_Depto> listar();
	public Jefes_Depto listarUsuario(Docente d);
	public int guardar(Jefes_Depto jefe);
	public void eliminar(int id);
}
