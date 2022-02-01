package it.beije.pascal.controller;


import java.util.ArrayList;
import java.util.List;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.pascal.model.Contatto;
import it.beije.pascal.service.RubricaService;


@Controller
public class RubricaController {
	
	public RubricaController() {
		System.out.println("creo RubricaController");
	}
	
	@Autowired
	private RubricaService rubricaService;
	

	@RequestMapping(value = "/contatto", method = RequestMethod.GET)
	public String contatto(Model model) {
		System.out.println("GET contatto");
		
		//carica rubrica da DB, CSV, XML...
		//RubricaService.getList()
		//RubricaService rubricaService = new RubricaService();
		
		List<Contatto> contatti = rubricaService.getList();
		System.out.println("contatti : " + contatti.size());
		
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
