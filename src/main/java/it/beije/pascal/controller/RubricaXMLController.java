package it.beije.pascal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.pascal.model.Contatto;
import it.beije.pascal.service.RubricaXMLService;

@Controller
public class RubricaXMLController {

	@Autowired
	private RubricaXMLService rubricaXMLService;
	
	@RequestMapping(value = "/rubricaXML", method = RequestMethod.GET)
	public String listaCSV(Model model) throws Exception {
		System.out.println("GET rubricaXML");
		
		String pathFile = "/rubrica.xml";
		
		//carica rubrica da CSV
		List<Contatto> contatti = rubricaXMLService.loadRubricaFromXML(pathFile);
		System.out.println("contatti : " + contatti.size());
		
		model.addAttribute("listaContatti", contatti);
		
		return "lista"; // /WEB-INF/views/hello.jsp
	}
}
