package com.qyf.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	private IUsuarioServ usuarios;
	
	@GetMapping("/usuarios")
	public String form_consultar(@RequestParam(value="buscar", required=false) String palabra, Model model) {
		List<Usuario> lista = usuarios.listar(palabra);
		lista.remove(0);
		model.addAttribute("buscar",palabra);
		model.addAttribute("usuarios", lista);
		
		return "listaUsuarios";
	}
	
	@GetMapping("/usuarios/{id}/recuperarContrasena")
	public String recuperar_contrasena(@PathVariable int id, Model model) {
		
		return "recuperarContrasena";
	}
	
	@GetMapping("/usuarios/registro")
	public String form_registro(Model model) {
		model.addAttribute("user", new Usuario());
		
		return "agregarUsuario";
	}
	
	@GetMapping("/usuarios/editar/{id}")
	public String form_editar(@PathVariable Integer id, Model model) {
		Optional<Usuario> user = usuarios.listarId(id);
		model.addAttribute("user", user);
		
		return "editarUsuario";
	}
	
	@PostMapping("/saveUser")
	public String registro(@Validated Usuario user) {		
		int r = user.getRole().getId_rol();
		if(r != 0) {
			String encodedPass = usuarios.encriptar(user.getPassword());
			user.setPassword(encodedPass); //Se guarda el password encriptado
			usuarios.guardar(user); //Guarda el usuario
			usuarios.asignarRole(r, user); //(aun no funciona bien)
		}
		
		return "redirect:/usuarios";
	}
	
	@GetMapping("/deleteUser/{id}")
	public String eliminar(@PathVariable int id, Model model) {
		usuarios.eliminar(id);
		
		return "redirect:/usuarios";
	}
}
