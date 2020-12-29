package com.qyf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qyf.interfaceService.ICoordinadorServ;
import com.qyf.model.Coordinador;
import com.qyf.repository.ICoordinador;

@Service
public class CoordService implements ICoordinadorServ {
	
	@Autowired
	private ICoordinador data;
	
	@Override
	public List<Coordinador> listar() {
		return data.findAll();
	}
}
