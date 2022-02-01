package it.beije.pascal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.pascal.service.ContattoService;

@Controller
public class RubWebController {

	@Autowired
	private ContattoService contattoService;
	
	//autowired service
	
	@RequestMapping(value = "/webRubrica", method = RequestMethod.GET)
	public String showContatti(Model model) {
		
		model.addAttribute("contatti", contattoService.findAll());
		
		return "RubricaHomepage";
	}
	
}
