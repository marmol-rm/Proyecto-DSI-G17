package com.qyf.interfaceService;

import java.util.List;
import java.util.Optional;

import com.qyf.model.Usuario;

public interface IUsuarioServ {
	public String encriptar(String password);
	public void asignarRole(int role, Usuario user);
	public List<Usuario> listar(String key);
	public Optional<Usuario> listarId(int id);
	public Usuario listarEmail(String email);
	public int guardar(Usuario user);
	public void eliminar(int id);
}
