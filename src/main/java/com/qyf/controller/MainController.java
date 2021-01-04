package com.qyf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.qyf.service.RoleService;
import com.qyf.service.UsuarioServ;

@Controller
public class MainController {
	@Autowired
	private RoleService roles;
	@Autowired
	private UsuarioServ users;
	
	@GetMapping("/")
	public String inicio() {
		roles.inicializar(); //Crea los roles si no estan
		//Crea un usuario por defecto
		users.iniciarAdmin(roles.listarId(4).get());
		
		return "index";
	}
}
