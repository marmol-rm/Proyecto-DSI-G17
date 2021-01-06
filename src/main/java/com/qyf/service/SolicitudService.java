package com.qyf.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qyf.interfaceService.ISolicitudServ;
import com.qyf.model.Solicitud;
import com.qyf.model.Tipo_Solicitud;
import com.qyf.repository.ISolicitud;
import com.qyf.repository.ITipoSolicitud;

@Service
public class SolicitudService implements ISolicitudServ {
	@Autowired
	ITipoSolicitud t_data;
	@Autowired
	ISolicitud data;
	
	@Override
	public List<Solicitud> listar(String key) {
		if(key != null)
			return data.findAll(key);
		else
			return data.findAll();
	}

	@Override
	public int guardar(Solicitud solicitud) {
		solicitud.setEstado(1);
		solicitud.setFecha_solicitud(LocalDate.now().toString());
		Solicitud s = data.save(solicitud);
		
		int res = 0;
		if(!s.equals(null))
			res = 1;
		
		return res;
	}

	@Override
	public void eliminar(int id) {
		data.deleteById(id);
	}

	@Override
	public List<Tipo_Solicitud> tipos() {

		return t_data.findAll();
	}
}
