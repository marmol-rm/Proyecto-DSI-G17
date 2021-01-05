package com.qyf.interfaceService;

import java.util.List;

import com.qyf.model.Solicitud;
import com.qyf.model.Tipo_Solicitud;

public interface ISolicitudServ {
	public void inicializar();
	public List<Solicitud> listar(String key);
	public List<Tipo_Solicitud> tipos();
	public int guardar(Solicitud s);
	public void eliminar(int id);
}
