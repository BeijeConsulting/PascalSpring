package it.beije.pascal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.pascal.model.Utente;
import it.beije.pascal.service.UtenteService;

@Controller
public class UtenteController {
	
	public UtenteService utenteservice;

	@RequestMapping(value="login", method = RequestMethod.GET)
	public String userLogin(Model model, HttpServletRequest request, @RequestParam String email, @RequestParam String password) {
		Utente loggedUser = null;
		
		try {
			loggedUser = utenteservice.login(email, password);
			request.getSession().setAttribute("loggedUser", loggedUser);
			
		} catch (Exception e) {
			System.out.println("Failed to login");
			e.printStackTrace();
			return "login";
		}
		
		return "home";
	}
}
