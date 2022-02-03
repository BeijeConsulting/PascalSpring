package it.beije.pascal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.pascal.model.Commerciale;
import it.beije.pascal.model.Indirizzo;
import it.beije.pascal.repository.IndirizzoRepository;
import it.beije.pascal.service.CommercialeService;
import it.beije.pascal.service.UtenteService;

@Controller
public class UtenteController {

	@Autowired 
	private UtenteService utenteService;
	
	@Autowired
	private CommercialeService commercialeService;
	
	@Autowired
	private IndirizzoRepository indirizzoRepository;
	
	
	@RequestMapping(name="registerCommerciale", method = RequestMethod.POST)
	public String registerCommerciale(Model model, @RequestParam String nomeRef, @RequestParam String cognomeRef, 
			@RequestParam String pIva, @RequestParam String ragioneSociale, @RequestParam String telefono, 
			@RequestParam String cap, @RequestParam String comune, @RequestParam String indirizzo, @RequestParam Integer nCivico) {
				
		Indirizzo ind = new Indirizzo();
		ind.setCap(cap);
		ind.setComune(comune);
		ind.setNCivico(nCivico);
		ind.setIndirizzo(indirizzo);
		
		Commerciale comm = new Commerciale();
		comm.setNomeRef(nomeRef);
		comm.setCognomeRef(cognomeRef);
		comm.setPIva(pIva);
		comm.setRagioneSociale(ragioneSociale);
		comm.setTelefono(telefono);
		
		//TODO passa per un service
		indirizzoRepository.save(ind);
		comm.setIndirizzo(ind);
		
		commercialeService.insertCommerciale(comm);	
		
		return "login";
	}
	
	
}
