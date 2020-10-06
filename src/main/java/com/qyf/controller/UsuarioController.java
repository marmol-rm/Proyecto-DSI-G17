package com.qyf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.qyf.model.Usuario;
import com.qyf.repository.IUsuario;

@Controller
public class UsuarioController {
	
	@Autowired
	private IUsuario service;
	
	@GetMapping("")
	public String inicio() {
		return "index";
	}
	
	@GetMapping("/usuarios")
	public String listar(Model model) {
		List<Usuario> lista = service.findAll();
		model.addAttribute("usuarios", lista);
		return "listaUsuarios";
	}
	
	@GetMapping("/registro")
	public String registrar(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "registroUsuario";
	}
	
	@PostMapping("/procesarRegistro")
	public String procesoRegistro(Usuario user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPass = encoder.encode(user.getPassword());
		user.setPassword(encodedPass);
		service.save(user);
		return "listaUsuarios";
	}
}
