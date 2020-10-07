package com.qyf.interfaceService;

import java.util.List;
import java.util.Optional;

import com.qyf.model.Usuario;

public interface IUsuarioServ {
	public List<Usuario> listar(String key);
	public Optional<Usuario> listarId(Long id);
	public int guardar(Usuario user);
	public void delete(Long id);
}
