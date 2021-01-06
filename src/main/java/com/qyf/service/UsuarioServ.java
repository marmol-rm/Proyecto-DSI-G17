package com.qyf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.qyf.interfaceService.IUsuarioServ;
import com.qyf.model.Coordinador;
import com.qyf.model.Docente;
import com.qyf.model.Estudiante;
import com.qyf.model.Jefes_Depto;
import com.qyf.model.Usuario;
import com.qyf.repository.IUsuario;

@Service
public class UsuarioServ implements IUsuarioServ{
	
	@Autowired
	private IUsuario data;
	@Autowired
	private EstudianteServ estudiantes;
	@Autowired
	private DocenteService docentes;
	@Autowired
	private CoordService coordinadores;
	@Autowired
	private JefeService jefes;
	
	@Override
	public List<Usuario> listar(String key) {
		if(key!=null) {
			return (List<Usuario>) data.findAll(key);
		}
		else
			return data.findAll();
	}

	@Override
	public Optional<Usuario> listarId(int id) {

		return data.findById(id);
	}
	
	@Override
	public String encriptar(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPass = encoder.encode(password);
		
		return encodedPass;
	}

	@Override
	public Usuario listarEmail(String email) {
		
		return data.findByEmail(email);
	}

	@Override
	public int guardar(Usuario user) {
		int res=0;
		Usuario u = data.save(user);
		if(!u.equals(null)) {
			res = 1;
		}
		
		return res;
	}

	@Override
	public void eliminar(int id) {
		data.deleteById(id);
	}

	@Override
	public void asignarRole(int role, Usuario user) {
		switch(role) {
		case 1: //Estudiante
			//Primero se verifica si el usuario ya es un estudiante
			if(estudiantes.listarUsuario(user) == null) {
				Estudiante e = new Estudiante(user);
				estudiantes.guardar(e);
			}
		break;
		case 2: //Coordinador
			Docente coo = new Docente(user);
			//Primero se verifica si el usuario ya es docente
			if(docentes.listarUsuario(user) == null) {
				docentes.guardar(coo);
				if(coordinadores.listarUsuario(coo) == null)
					coordinadores.guardar(new Coordinador(coo));
			}
			else {
				if(coordinadores.listarUsuario(coo) == null)
					coordinadores.guardar(new Coordinador(coo));
			}
		break;
		case 3: //Jefe
			Docente jefe = new Docente(user);
			//Primero se verifica si el usuario ya es docente
			if(docentes.listarUsuario(user) == null) {
				docentes.guardar(jefe);
				if(jefes.listarUsuario(jefe) == null)
					jefes.guardar(new Jefes_Depto(jefe));
			}
			else {
				if(jefes.listarUsuario(jefe) == null)
					jefes.guardar(new Jefes_Depto(jefe));
			}
		break;
	}
	}
}
