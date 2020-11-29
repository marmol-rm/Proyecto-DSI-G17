package com.qyf.interfaceService;

import java.util.List;
import java.util.Optional;

import com.qyf.model.Curso;

public interface ICursoServ {
	public List<Curso> listar(String key);
	public Optional<Curso> listarId(int id);
	public int guardar(Curso curso);
	public void delete(int id);
}
