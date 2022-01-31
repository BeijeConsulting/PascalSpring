package it.beije.pascal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.pascal.model.Contatto;


@Controller
public class RubricaController {

	@RequestMapping(value = "/contatto", method = RequestMethod.GET)
	public String contatto(Model model) {
		System.out.println("GET contatto");
		
		//carica rubrica da DB, CSV, XML...
		Contatto c = new Contatto();
		c.setNome("Claudio");
		c.setCognome("Bisio");
		
		model.addAttribute("contatto", c);
		
		return "contatto"; // /WEB-INF/views/hello.jsp
	}
	
	@RequestMapping(value = "/rubrica", method = RequestMethod.GET)
	public String rubrica(Model model) {
		System.out.println("GET rubrica");
		
		//carica rubrica da DB, CSV, XML...
		Contatto c = new Contatto();
		c.setNome("Claudio");
		c.setCognome("Bisio");
		Contatto c1 = new Contatto();
		c.setNome("Claudio");
		c.setCognome("Bisio");
		
		List<Contatto> l = new ArrayList<>();
		l.add(c);
		l.add(c1);
		
		
		model.addAttribute("l", l);
		
		return "rubrica"; // /WEB-INF/views/hello.jsp
	}

}
