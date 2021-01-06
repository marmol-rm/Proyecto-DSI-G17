package com.qyf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.qyf.interfaceService.IMainService;

@Controller
public class MainController {
	@Autowired
	private IMainService main;
	
	@GetMapping("/")
	public String inicio() {
		//Inicializa valores fijos en BD
		main.inicializar();
		
		return "index";
	}
}
