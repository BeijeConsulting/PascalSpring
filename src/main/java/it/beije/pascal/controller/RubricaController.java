package it.beije.pascal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.pascal.model.Contatto;


@Controller
public class RubricaController {

	@RequestMapping(value = "/rubrica", method = RequestMethod.GET)
	public String lista(Model model) {
		System.out.println("GET rubrica");
		
		//carica rubrica da DB, CSV, XML...
		Contatto c = new Contatto();
		c.setNome("Claudio");
		c.setCognome("Bisio");
		
		//model.addAttribute("contatto", c);
		
		return "lista"; // /WEB-INF/views/hello.jsp
	}

}
