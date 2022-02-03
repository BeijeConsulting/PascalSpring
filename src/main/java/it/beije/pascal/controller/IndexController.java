package it.beije.pascal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	// Controller di partenza
	@GetMapping(value = "/")
	public String index() {		
		// Si indica la pagina a cui reindirizzare
		return "index";
	
	}
	

}
