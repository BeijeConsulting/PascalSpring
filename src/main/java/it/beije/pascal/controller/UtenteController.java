package it.beije.pascal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.pascal.model.Utente;
import it.beije.pascal.service.UtenteService;

@Controller
public class UtenteController {

	@Autowired
	UtenteService utenteService;

	@GetMapping(value = "/")
	public String homepage() {
		return "index";
	}

	@RequestMapping(value = "/form_privato", method = RequestMethod.GET)
	public String formPrivato() {
		return "registrazione_privato";

	}

	@RequestMapping(value = "/form_commerciale", method = RequestMethod.GET)
	public String formCommerciale() {
		return "registrazione_commerciale";

	}

	@RequestMapping(value = "/registrazione_privato", method = RequestMethod.POST)
	public String registraPrivato(@RequestParam(required = false) String username,
			@RequestParam(required = false) String email, @RequestParam(required = false) String password,@RequestParam(required = false) String spam) {
		Utente utente = null;
		if (spam == null) {
			utente = new Utente(email, password, (byte) 0, username);
		} else {
			utente = new Utente(email, password, (byte) 1, username);
		}
		utenteService.save(utente);
		return "index";
	}
	
	
}
