package com.qyf.interfaceService;

import java.util.List;

import com.qyf.model.Coordinador;

public interface ICoordinadorServ {
	public List<Coordinador> listar();
	public int guardar(Coordinador c);
	public void eliminar(int id);
}
