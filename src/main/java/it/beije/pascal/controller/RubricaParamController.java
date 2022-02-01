package it.beije.pascal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RubricaParamController {
	
	@RequestMapping(value="/rubrica", method = RequestMethod.GET)
	public String getRubrica() {
		return "lista";
	}
	
	@RequestMapping(value="/rubrica", method = RequestMethod.POST)
	public String postRubrica(Model model, @RequestParam String type) {
		
		switch(type) {
		case "CSV": {
			return "redirect:/rubricaCSV";
		}
		case "XML": {
			return "redirect:/rubricaXML";
		}
		default: {
			return "lista";
		}
		}
	}	
}
