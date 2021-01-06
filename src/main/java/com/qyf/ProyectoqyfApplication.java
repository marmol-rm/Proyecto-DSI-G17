package com.qyf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.qyf.interfaceService.IMainService;

@SpringBootApplication
public class ProyectoqyfApplication {
	@Autowired
	private IMainService main;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoqyfApplication.class, args);
		main.inicializar();
	}

}
