package com.qyf.interfaceService;

import java.util.List;

import com.qyf.model.Solicitud;

public interface ISolicitudServ {
	public void inicializar();
	public List<Solicitud> listar();
	public int guardar(Solicitud s);
	public void eliminar(int id);
}
