package com.qyf.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qyf.interfaceService.IDepartamentoServ;
import com.qyf.model.Departamento;

@Controller
@RequestMapping
public class DepartamentoController {
	@Autowired
	private IDepartamentoServ serv;
	
	@GetMapping("/departamentos")
	public String listar(Model model) {
		List<Departamento> departamentos = serv.listar();
		model.addAttribute("departamentos",departamentos);
		return "listaDepartamentos";
	}
}
