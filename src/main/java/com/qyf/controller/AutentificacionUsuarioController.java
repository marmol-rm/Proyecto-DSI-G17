package com.qyf.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AutentificacionUsuarioController {
	@Autowired
    AuthenticationTrustResolver authenticationTrustResolver;
	
	 @GetMapping("/login")
	    public String mostrarLogin(ModelMap model) {
	        if (isCurrentAuthenticationAnonymous()) {
	            return "Login";
	        } else {
	            return "Inicio";
	        }
	    }

	    @GetMapping("/logout")
	    public String salir() {	       
	        return "redirect:/login?logout";
	    }

	    @GetMapping("/accesDenied")
	    public String mostrarAccesoDenegado(ModelMap model, Principal principal) {
	        model.addAttribute("usuario", principal.getName());
	        return "AccesoDenegado";
	    }

	    private boolean isCurrentAuthenticationAnonymous() {
	        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        return authenticationTrustResolver.isAnonymous(authentication);
	    }
}
