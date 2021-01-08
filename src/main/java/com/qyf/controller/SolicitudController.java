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

import com.qyf.interfaceService.IEvaluacionServ;
import com.qyf.interfaceService.ISolicitudServ;
import com.qyf.model.Evaluacion;
import com.qyf.model.Solicitud;
import com.qyf.model.Tipo_Solicitud;

@Controller
public class SolicitudController {
	@Autowired
	private ISolicitudServ solicitudes;
	@Autowired
	private IEvaluacionServ evaluaciones;
	
	@GetMapping("/solicitudes/lista-solicitudes")
	public String form_consultar(@RequestParam(value="buscar", required=false) String palabra, Model model) {
		List<Solicitud> lista = solicitudes.listar(palabra);
		model.addAttribute("buscar",palabra);
		model.addAttribute("solicitudes", lista);
		
		return "listaSolicitudes";
	}
	
	@GetMapping("/solicitudes")
	public String form_tipos(Model model) {
		
		return "tipoSolicitud";
	}
	
	@GetMapping("/solicitudes/{id}/agregar")
	public String form_agregar(@PathVariable int id, Model model) {
		model.addAttribute("solicitud", new Solicitud());
		List<Evaluacion> lista_ev = evaluaciones.listar(null);
		model.addAttribute("evaluaciones", lista_ev);
		
		switch(id) {
			case 1: return "solicitudRepetido";
			case 2: return "solicitudDiferido";
			case 3: return "solicitudRevision";
			case 4: return "solicitudCambioFecha";
			default: return "error";
		}
	}
	
	@GetMapping("/solicitudes/revisar/{id}")
	public String form_editar(@PathVariable int id, Model model) {
		Optional<Solicitud> s = solicitudes.listarId(id);
		model.addAttribute("solicitud", s);
		List<Tipo_Solicitud> lista_tipos = solicitudes.tipos();
		List<Evaluacion> lista_ev = evaluaciones.listar(null);
		model.addAttribute("tipos", lista_tipos);
		model.addAttribute("evaluaciones", lista_ev);
		
		return "revisarSolicitud";
	}
	
	@PostMapping("/saveRep")
	public String guardarRep(@Validated Solicitud sol, Model model) {
		if(sol.getEvaluacion().getId_evaluacion() != 0) {
			List<Tipo_Solicitud> lista_tipos = solicitudes.tipos();
			sol.setTipo(lista_tipos.get(0));
			solicitudes.guardar(sol);
		}
		
		return "redirect:/solicitudes";
	}
	
	@PostMapping("/saveDif")
	public String guardarDif(@Validated Solicitud sol, Model model) {
		if(sol.getEvaluacion().getId_evaluacion() != 0) {
			List<Tipo_Solicitud> lista_tipos = solicitudes.tipos();
			sol.setTipo(lista_tipos.get(1));
			solicitudes.guardar(sol);
		}
		
		return "redirect:/solicitudes";
	}
	
	@PostMapping("/saveRev")
	public String guardarRev(@Validated Solicitud sol, Model model) {
		if(sol.getEvaluacion().getId_evaluacion() != 0) {
			List<Tipo_Solicitud> lista_tipos = solicitudes.tipos();
			sol.setTipo(lista_tipos.get(2));
			solicitudes.guardar(sol);
		}
		
		return "redirect:/solicitudes";
	}
	
	@PostMapping("/saveCambioF")
	public String guardarCambioFecha(@Validated Solicitud sol, Model model) {
		if(sol.getEvaluacion().getId_evaluacion() != 0) {
			List<Tipo_Solicitud> lista_tipos = solicitudes.tipos();
			sol.setTipo(lista_tipos.get(3));
			solicitudes.guardar(sol);
		}
		
		return "redirect:/solicitudes";
	}
	
	@PostMapping("/saveRevision")
	public String guardarRevision(@Validated Solicitud sol, Model model) {
		if(sol.getEvaluacion().getId_evaluacion() != 0 
			&& sol.getEstado() != 0)
			solicitudes.guardar(sol);
		
		return "redirect:/solicitudes/lista-solicitudes";
	}
	
	@GetMapping("/deleteSolicitud/{id}")
	public String eliminar(@PathVariable int id, Model model) {
		solicitudes.eliminar(id);
		
		return "redirect:/solicitudes/lista-solicitudes";
	}
}
