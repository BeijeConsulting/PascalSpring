package it.beije.pascal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.pascal.model.Annuncio;
import it.beije.pascal.model.enums.TipoAnnuncio;
import it.beije.pascal.model.enums.TipoImmobile;
import it.beije.pascal.service.AnnuncioService;

import it.beije.pascal.model.enums.*;

@Controller
public class AnnuncioController {
	
	@Autowired
	private AnnuncioService annuncioService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("annunci", annuncioService.findAllAnnunci());
		
		return "homepage";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "redirect:/";
	}
	
	@RequestMapping(value = "/visualizzaDettagli", method = RequestMethod.GET)
	public String showAnnuncio(Model model, @RequestParam Integer id) {	
		Annuncio annuncio = annuncioService.getOneAnnuncio(id).get();
		
		model.addAttribute("annuncio", annuncio);
		
		return "visualAnnuncio";
	}
	
	@RequestMapping(value = "/inserisciAnnuncio", method = RequestMethod.GET)
	public String formInsertAnnuncio(Model model) {	
		
		return "form_inserisci_annuncio";
	}
	
	@RequestMapping(value = "/inserisciAnnuncio", method = RequestMethod.POST)
	public String insertAnnuncio(Model model) {	
	
		return "visualAnnuncio";
	}
	
}

