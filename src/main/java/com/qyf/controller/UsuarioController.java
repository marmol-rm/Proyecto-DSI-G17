package com.qyf.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qyf.interfaceService.ICoordinadorServ;
import com.qyf.interfaceService.IDocenteServ;
import com.qyf.interfaceService.IEstudianteServ;
import com.qyf.interfaceService.IJefeServ;
import com.qyf.interfaceService.IUsuarioServ;
import com.qyf.model.Coordinador;
import com.qyf.model.Docente;
import com.qyf.model.Estudiante;
import com.qyf.model.Jefes_Depto;
import com.qyf.model.Usuario;

@Controller
public class UsuarioController {
	
	@Autowired
	private IUsuarioServ usuarios;
	@Autowired
	private IEstudianteServ estudiantes;
	@Autowired
	private IDocenteServ docentes;
	@Autowired
	private ICoordinadorServ coordinadores;
	@Autowired
	private IJefeServ jefes;
	
	@GetMapping("/usuarios")
	public String form_consultar(@RequestParam(value="buscar", required=false) String palabra, Model model) {
		List<Usuario> lista = usuarios.listar(palabra);
		model.addAttribute("buscar",palabra);
		model.addAttribute("usuarios", lista);
		
		return "listaUsuarios";
	}
	
	@GetMapping("/usuarios/{id}/recuperarContrasena")
	public String recuperar_contrasena(@PathVariable Long id, Model model) {
		
		return "recuperarContrasena";
	}
	
	@GetMapping("/usuarios/registro")
	public String form_registro(Model model) {
		model.addAttribute("user", new Usuario());
		
		return "agregarUsuario";
	}
	
	@GetMapping("/usuarios/editar/{id}")
	public String form_editar(@PathVariable Long id, Model model) {
		Optional<Usuario> user = usuarios.listarId(id);
		model.addAttribute("user", user);
		
		return "editarUsuario";
	}
	
	@PostMapping("/saveUser")
	public String registro(@Validated Usuario user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPass = encoder.encode(user.getPassword());
		user.setPassword(encodedPass); //Se guarda el password encriptado
		int rol = user.getRole().getId_rol();
		if(rol != 0)
			usuarios.guardar(user); //Guarda el usuario
		
		switch(rol) {
			case 1: //Estudiante
				Estudiante e = new Estudiante(user);
				estudiantes.guardar(e);
			break;
			case 2: //Coordinador
				Docente coo = new Docente(user);
				docentes.guardar(coo);
				coordinadores.guardar(new Coordinador(coo));
			break;
			case 3: //Jefe
				Docente jefe = new Docente(user);
				docentes.guardar(jefe);
				jefes.guardar(new Jefes_Depto(jefe));
			break;
		}
		
		return "redirect:/usuarios";
	}
	
	@GetMapping("/deleteUser/{id}")
	public String eliminar(@PathVariable Long id, Model model) {
		usuarios.delete(id);
		
		return "redirect:/usuarios";
	}
}
