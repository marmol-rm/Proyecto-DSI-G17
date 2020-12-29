package com.qyf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qyf.interfaceService.IJefeServ;
import com.qyf.model.Jefes_Depto;
import com.qyf.repository.IJefes;

@Service
public class JefeService implements IJefeServ{
	
	@Autowired
	private IJefes data;
	
	@Override
	public List<Jefes_Depto> listar() {
		return (List<Jefes_Depto>) data.findAll();
	}
}
