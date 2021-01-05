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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qyf.interfaceService.IEvaluacionServ;
import com.qyf.interfaceService.ISolicitudServ;
import com.qyf.model.Departamento;
import com.qyf.model.Evaluacion;
import com.qyf.model.Jefes_Depto;
import com.qyf.model.Solicitud;
import com.qyf.model.Tipo_Solicitud;

@Controller
public class SolicitudController {
	private String ev;
	@Autowired
	private ISolicitudServ solicitudes;
	@Autowired
	private IEvaluacionServ evaluaciones;
	
	@RequestMapping("/solicitudes")
	public String form_consultar(@RequestParam(value="buscar", required=false) String palabra, Model model) {
		List<Solicitud> lista = solicitudes.listar(palabra);
		model.addAttribute("buscar",palabra);
		model.addAttribute("solicitudes", lista);
		
		return "listaSolicitudes";
	}
	
	@GetMapping("/solicitudes/agregar")
	public String form_agregar(Model model) {
		model.addAttribute("solicitud", new Solicitud());
		List<Tipo_Solicitud> lista_tipos = solicitudes.tipos();
		List<Evaluacion> lista_ev = evaluaciones.listar(null);
		model.addAttribute("tipos", lista_tipos);
		model.addAttribute("evaluaciones", lista_ev);
		
		return "agregarSolicitud";
	}
	/*
	@GetMapping("/departamentos/editar/{id}")
	public String form_editar(@PathVariable int id, Model model) {
		Optional<Departamento> depto = departamentos.listarId(id);
		List<Jefes_Depto> lista_jefes = jefes.listar();
		model.addAttribute("depto", depto);
		model.addAttribute("jefes", lista_jefes);
		
		return "editarDepartamento";
	}
	*/
	@PostMapping("/saveSolicitud")
	public String guardar(@Validated Solicitud sol, Model model) {
		solicitudes.guardar(sol);
		
		return "redirect:/solicitudes";
	}
	
	@GetMapping("/deleteSolicitud/{id}")
	public String eliminar(@PathVariable int id, Model model) {
		solicitudes.eliminar(id);
		
		return "redirect:/solicitudes";
	}
}
