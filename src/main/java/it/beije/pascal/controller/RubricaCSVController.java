package it.beije.pascal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.pascal.model.Contatto;
import it.beije.pascal.service.RubricaCSVService;

@Controller
public class RubricaCSVController {
	
	@Autowired
	private RubricaCSVService rubricaCSVService;
	
	@RequestMapping(value = "/rubricaCSV", method = RequestMethod.GET)
	public String listaCSV(Model model) {
		System.out.println("GET rubricaCSV");
		
		String pathFile = "/rubrica.csv";
		String separator = ";";
		
		//carica rubrica da CSV
		List<Contatto> contatti = rubricaCSVService.loadRubricaFromCSV(pathFile, separator);
		System.out.println("contatti : " + contatti.size());
		
		model.addAttribute("contatti", contatti);
		
		return "lista"; // /WEB-INF/views/hello.jsp
	}

}
