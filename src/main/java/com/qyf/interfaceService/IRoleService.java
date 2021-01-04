package com.qyf.interfaceService;

import java.util.List;
import java.util.Optional;

import com.qyf.model.Role;

public interface IRoleService {
	public void inicializar();
	public List<Role> listar();
	public Optional<Role> listarId(int id);
}
