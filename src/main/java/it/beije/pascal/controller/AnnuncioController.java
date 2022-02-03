package it.beije.pascal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.pascal.service.AnnuncioService;

@Controller
public class AnnuncioController {
	
	@Autowired
	private AnnuncioService annuncioService;
	
	@RequestMapping(value = "/homepage", method = RequestMethod.GET)
	public String home(Model model) {
		
		model.addAttribute("annunci", annuncioService.findAllAnnunci());
		
		return "homepage";
	}
}

