package it.beije.pascal.controller;

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
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.pascal.model.Contatto;
import it.beije.pascal.repository.RubricaRepository;
import it.beije.pascal.service.RubricaService;
import it.beije.pascal.service.CSVService;


@Controller
public class RubricaController {
	
	public RubricaController() {
		System.out.println("creo RubricaController");
	}
	
	@Autowired
	private RubricaService rubricaService;

	@Autowired
	private RubricaRepository rubricaRepository;


	

	@RequestMapping(value = "/rubrica", method = RequestMethod.GET)
	public String lista(Model model, @RequestParam(value = "surname", required = false) String cognome) {
		System.out.println("GET rubrica");
		
		//carica rubrica da DB, CSV, XML...
		//RubricaService.getList()
		//RubricaService rubricaService = new RubricaService();
		
		//List<Contatto> contatti = rubricaService.getList();

		List<Contatto> contatti = cognome != null ? rubricaRepository.findByCognome(cognome) : rubricaRepository.findAll();
		System.out.println("contatti : " + contatti.size());
		
		model.addAttribute("contatti", contatti);
		
		return "lista"; // /WEB-INF/views/hello.jsp
	}

}
