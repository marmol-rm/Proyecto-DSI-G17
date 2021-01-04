package com.qyf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.qyf.interfaceService.IRoleService;
import com.qyf.interfaceService.IUsuarioServ;

@Controller
public class MainController {
	@Autowired
	private IRoleService roles;
	@Autowired
	private IUsuarioServ users;
	
	@GetMapping("/")
	public String inicio() {
		roles.inicializar(); //Crea los roles si no estan
		//Crea un usuario por defecto
		users.iniciarAdmin(roles.listarId(4).get());
		
		return "index";
	}
}
