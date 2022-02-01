package it.beije.pascal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.pascal.model.Contatto;
import it.beije.pascal.service.RubricaCSVService;
import it.beije.pascal.service.RubricaXMLService;

@Controller
public class RubricaTipoController {
	
	@Autowired
	private RubricaCSVService rubricaCSVService;
	private RubricaXMLService rubricaXMLService;
	
	@RequestMapping(value = "/rubricaTipo", method = RequestMethod.GET)
	public String listContatti(Model model, @RequestParam String pathFile, @RequestParam String button) throws Exception {
		List<Contatto> contatti = null;
		
		if(button.equals("CSV")) {
			contatti = rubricaCSVService.loadRubricaFromCSV(pathFile, ";");
		}else {
			contatti = rubricaXMLService.loadRubricaFromXML(pathFile);
		}
		
		model.addAttribute("listaContatti", contatti);
		
		return "StampaContatti";
		
	}

}
