package com.qyf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qyf.interfaceService.IUsuarioServ;
import com.qyf.model.Usuario;

@Controller
public class UsuarioController {
	
	@Autowired
	private IUsuarioServ service;
	
	@GetMapping("")
	public String inicio() {
		return "index";
	}
	
	@GetMapping("/usuarios")
	public String listar(@RequestParam(value="buscar", required=false) String palabra, Model model) {
		List<Usuario> lista = service.listar(palabra);
		model.addAttribute("usuarios", lista);
		return "listaUsuarios";
	}
	
	@GetMapping("/registro")
	public String registrar(Model model) {
		model.addAttribute("user", new Usuario());
		return "registroUsuario";
	}
	
	@PostMapping("/procesarRegistro")
	public String procesoRegistro(Usuario user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPass = encoder.encode(user.getPassword());
		user.setPassword(encodedPass); //Se guarda el password codificado
		service.guardar(user);
		return "redirect:listaUsuarios";
	}
	
	@GetMapping("/editarUsuario/{id}")
	public String editar(@PathVariable Long id, Model model) {
		java.util.Optional<Usuario> user = service.listarId(id);
		model.addAttribute("user", user);
		return "editarUsuario";
	}
	
	@PostMapping("/editUser")
	public String edit(@Validated Usuario user, Model model) {
		model.getAttribute("user");
		service.guardar(user);
		return "redirect:/usuarios";
	}
	
	@GetMapping("eliminarUsuario/{id}")
	public String delete(@PathVariable Long id, Model model) {
		service.delete(id);
		return "redirect:/usuarios";
	}
}
