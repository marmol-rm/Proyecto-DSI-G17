package com.qyf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.qyf.interfaceService.IUsuarioServ;
import com.qyf.model.Role;
import com.qyf.model.Usuario;

@Controller
public class MainController {
	
	@Autowired
	private IUsuarioServ service;
	
	@GetMapping("")
	public String inicio() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Usuario user = new Usuario();
		Role rol =new Role();
		rol.setId_rol(1);
		rol.setNombre("Administrador");
		rol.setDescripcion("Rol admin");
		user.setNombres("prueba");
		user.setApellidos("prueba");
		user.setActivo(1);
		user.setRole(rol);
		user.setEmail("prueba@email.com");
		String encodedPass = encoder.encode("123");
		user.setPassword(encodedPass); //Se guarda el password codificado
		service.guardar(user);
		return "index";
	}
}
