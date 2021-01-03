package com.qyf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {
	
	/*@Autowired
	private UsuarioController controller;
	private static int flag = 0;
	private String dir = null;
	
	@GetMapping("/")
	public String inicio(Model model) {
		if(flag == 0) {
			flag += 1;
			dir = controller.registrar(model);
		}
		else
			dir = "index";
		return dir;
	}*/
	
	@GetMapping("/error")
	public String pagina_error() {
		
		return "error";
	}
}
