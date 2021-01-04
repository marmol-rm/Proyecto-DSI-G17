package com.qyf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qyf.interfaceService.IRoleService;
import com.qyf.model.Role;
import com.qyf.repository.IRole;

@Service
public class RoleService implements IRoleService {
	@Autowired
	private IRole data;

	@Override
	public void inicializar() {
		long vacio = data.count();
		if(vacio == 0) {
			Role e = new Role("Estudiante","Rol de estudiante");
			data.save(e);
			Role c = new Role("Coordinador","Rol del coordinador de catedra");
			data.save(c);
			Role j = new Role("Jefe de Departamento","Rol del jefe de departamento");
			data.save(j);
			Role a = new Role("Admin","Rol de administrador del sistema");
			data.save(a);
		}
	}

	@Override
	public List<Role> listar() {

		return data.findAll();
	}

	@Override
	public Optional<Role> listarId(int id) {
		
		return data.findById(id);
	}
}
