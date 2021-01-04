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

import com.qyf.interfaceService.IUsuarioServ;
import com.qyf.model.Usuario;

@Controller
public class UsuarioController {
	
	@Autowired
	private IUsuarioServ service;
	
	@GetMapping("/usuarios")
	public String form_consultar(@RequestParam(value="buscar", required=false) String palabra, Model model) {
		List<Usuario> lista = service.listar(palabra);
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
		Optional<Usuario> user = service.listarId(id);
		model.addAttribute("user", user);
		
		return "editarUsuario";
	}
	
	@PostMapping("/saveUser")
	public String registro(Usuario user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPass = encoder.encode(user.getPassword());
		user.setPassword(encodedPass); //Se guarda el password encriptado
		service.guardar(user);
		
		return "redirect:/usuarios";
	}
	
	@GetMapping("/deleteUser/{id}")
	public void eliminar(@PathVariable Long id, Model model) {
		service.delete(id);
		
		return;
	}
}
