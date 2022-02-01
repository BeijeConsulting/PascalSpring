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
public class RubricaXMLController {
	
	@Autowired
	private RubricaService rubricaService;
	
	@RequestMapping(value = "/rubricaXML", method = RequestMethod.GET)
	public String listaCSV(Model model) {
		
		List<Contatto> contatti = rubricaService.getContattiCSV();
		model.addAttribute("contatti", contatti);
		
		return "listaXML";
	}
}