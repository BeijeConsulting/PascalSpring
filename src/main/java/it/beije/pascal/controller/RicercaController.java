package it.beije.pascal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.pascal.model.Annuncio;
import it.beije.pascal.model.Ricerca;
import it.beije.pascal.service.AnnuncioService;
import it.beije.pascal.service.RicercaService;

@Controller
public class RicercaController {
	
	@Autowired
	private RicercaService ricercaService;
	
	@RequestMapping(value = "/ricerca", method = RequestMethod.GET)
	public String search(Model model, @RequestParam String tipoImmobile, @RequestParam String comune, @RequestParam String tipoAnnuncio) {
		
		List<Annuncio> annunci = ricercaService.search(tipoAnnuncio, tipoImmobile, comune);
				//annuncioService.metodo(tipoAnnuncio, tipoImmobile, comune);
			
		model.addAttribute("annunci", annunci);
		model.addAttribute("tipoImmobile", tipoImmobile);
		model.addAttribute("tipoAnnuncio", tipoAnnuncio);
		model.addAttribute("comune", comune);
		
		return "ricercaAnnunci";
	}
	
	@RequestMapping(value = "/salvaRicerca", method = RequestMethod.POST)
	public String save(Model model, @RequestParam Integer ricercaId, @RequestParam Integer utenteId) {
		
		return "redirect:/homepage";
	}
	
}
