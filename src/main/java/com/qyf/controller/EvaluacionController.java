package com.qyf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.qyf.model.Evaluacion;
import com.qyf.service.EvaluacionServ;

@Controller
public class EvaluacionController {
	@Autowired
	private EvaluacionServ service;
	
	@GetMapping("/editar-materia-imp/{id}/evaluaciones")
	public String consultar(@PathVariable int id, Model model) {
		List<Evaluacion> lista = service.listar();
		if(!lista.isEmpty()) {
			for(int i = 0;i < lista.size();i++) {
				if(lista.get(i).getMateria().getId_materia_imp() != id)
					lista.remove(i);
				}
		}
		model.addAttribute("evaluaciones", lista);
		
		return "listaEvaluaciones";
	}
}
