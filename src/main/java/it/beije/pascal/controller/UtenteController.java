package it.beije.pascal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.pascal.model.Utente;
import it.beije.pascal.service.UtenteService;

@Controller
public class UtenteController {
	
	@Autowired
	UtenteService utenteService;
	
	// Controller di partenza
		@GetMapping(value = "/")
		public String index() {		
			// Si indica la pagina a cui reindirizzare
			return "index";		
		}
		
		public String registraPrivato(@RequestParam String username, @RequestParam String email, @RequestParam String password, @RequestParam byte spam) {
			Utente utente = new Utente(email,password,spam,username);
			return "registrazione_privato";
			
		}
		

}
