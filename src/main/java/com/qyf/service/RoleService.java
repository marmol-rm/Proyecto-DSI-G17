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
	public List<Role> listar() {

		return data.findAll();
	}

	@Override
	public Optional<Role> listarId(int id) {
		
		return data.findById(id);
	}
}
