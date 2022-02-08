package it.beije.pascal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.beije.pascal.model.Annuncio;
import it.beije.pascal.model.Ricerca;
import it.beije.pascal.service.RicercaService;

@RestController
public class RicercaController {
	
	@Autowired
	private RicercaService ricercaService;
	
	@GetMapping(value = "/ricerca")
	public List<Annuncio> findAll() {
		
		List<Annuncio> annunci = ricercaService.findAll();
		
		return annunci;
	}
	
	@RequestMapping(value = "/salvaRicerca", method = RequestMethod.POST)
	public String save(Model model, @RequestParam Integer ricercaId, @RequestParam Integer utenteId) {
		
		return "redirect:/homepage";
	}
	
}
