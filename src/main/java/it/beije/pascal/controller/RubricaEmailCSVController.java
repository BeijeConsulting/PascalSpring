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
public class RubricaEmailCSVController {
	
	@Autowired
	private RubricaService rubricaService;
	
	@RequestMapping(value="/rubricaEmailCSV", method=RequestMethod.GET)
	public String emailCSV(Model model) {
		
		List<Contatto> contatti = rubricaService.getContattiCSV();
		
		for(Contatto c : contatti) {
			if(c.getEmail() == null) {
				contatti.remove(c);
			}
		}
		
		model.addAttribute("contatti", contatti);
		
		return "rubricaEmailCSV";
	}
	
}
