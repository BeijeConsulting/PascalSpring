package it.beije.pascal.controller;

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
	

	@RequestMapping(value = "/rubrica", method = RequestMethod.GET)
	public String lista(Model model) {
		System.out.println("GET rubrica");
		
		//carica rubrica da DB, CSV, XML...
		//RubricaService.getList()
		//RubricaService rubricaService = new RubricaService();
		
		List<Contatto> contatti = rubricaService.getList();
		System.out.println("contatti : " + contatti.size());
		
		//model.addAttribute("contatto", c);
		
		return "lista"; // /WEB-INF/views/hello.jsp
	}

	@RequestMapping(value = "/rubrica/CSV", method = RequestMethod.GET)
	public String listCSV(Model model){
		System.out.println("lista da CSV");

		List<Contatto> contattoList = rubricaService.getCSV();
		model.addAttribute("listaContatti", contattoList);

		return "lista";
	}

}
