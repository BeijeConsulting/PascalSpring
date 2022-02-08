package it.beije.pascal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.pascal.model.Annuncio;
import it.beije.pascal.model.Indirizzo;
import it.beije.pascal.model.User;
import it.beije.pascal.model.enums.TipoAnnuncio;
import it.beije.pascal.model.enums.TipoImmobile;
import it.beije.pascal.service.AnnuncioService;
import it.beije.pascal.service.IndirizzoService;
import it.beije.pascal.model.enums.*;

@Controller
public class AnnuncioController {
	
	@Autowired
	private AnnuncioService annuncioService;
	
	@Autowired
	private IndirizzoService indirizzoService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("annunci", annuncioService.findAllAnnunci());
		
		return "homepage";
	}
	
	@RequestMapping(value = "/home_commerciale", method = RequestMethod.GET)
	public String homeCommerciale(Model model) {
		model.addAttribute("annunci", annuncioService.findAllAnnunci());
		
		return "homepage_commerciale";
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
	public String insertAnnuncio(HttpServletRequest request, Model model, @RequestParam TipoImmobile tipo_immobile, @RequestParam TipoAnnuncio tipo_annuncio,
			@RequestParam AriaCondizionata aria_condizionata, @RequestParam ClasseEnergetica classe_energetica, @RequestParam Condizione condizione, 
			@RequestParam Giardino giardino, @RequestParam Riscaldamento riscaldamento,
			@RequestParam String arredamento, @RequestParam String stato_rogito, @RequestParam String comune, 
			@RequestParam String indirizzo, @RequestParam String numero_civico, @RequestParam String cap,
			@RequestParam String prezzo,@RequestParam String mq, @RequestParam String locali, @RequestParam String bagni,
			@RequestParam String tot_piani, @RequestParam String piano, 
			@RequestParam String posti_auto, @RequestParam String anno_costruzione, 
			@RequestParam String descrizione_lunga) {	
	
		//FIXME
		//TUTTE LE CHECKBOX MANCANO (causano errori)
		//, @RequestParam String ascensore -> MANCA NELLA LISTA DEI PARAMETRI
		//, @RequestParam String balcone -> MANCA NELLA LISTA DEI PARAMETRI
		//@RequestParam String terrazzo,@RequestParam String piscina,@RequestParam String portineria -> MANCANO NELLA LISTA DEI PARAMETRI
		//@RequestParam String visita_guidata, @RequestParam String virtual_tour -> MANCANO NELLA LISTA DEI PARAMETRI
		
		Annuncio annuncio = new Annuncio();
		annuncio.setTipoImmobile(tipo_immobile);
		annuncio.setTipoAnnuncio(tipo_annuncio);
		annuncio.setAriaCondizionata(aria_condizionata);
		annuncio.setClasseEnergetica(classe_energetica);
		annuncio.setCondizione(condizione);
		annuncio.setArredamento(arredamento);
		annuncio.setStatoRogito(stato_rogito);
		
		annuncio.setPrezzo(Integer.parseInt(prezzo));
		annuncio.setMq(Integer.parseInt(mq));
		annuncio.setLocali(Integer.parseInt(locali));
		annuncio.setBagni(Integer.parseInt(bagni));
		annuncio.setTotPiani(Integer.parseInt(tot_piani));
		annuncio.setPiano(Integer.parseInt(piano));
		
		//TODO
		//annuncio.setAscensore();
		
		annuncio.setPostiAuto(Integer.parseInt(posti_auto));
		
		//TODO
		//annuncio.setBalcone(null);
		//annuncio.setTerrazzo(null);
		//annuncio.setPiscina(null);
		//annuncio.setPortineria(null);
		//set anno costruzione? 
		
		annuncio.setVisitaGuidata(Boolean.FALSE);
		annuncio.setVirtualTour(Boolean.FALSE);
		
		annuncio.setDescrizioneLunga(descrizione_lunga);
		
		//OGGETTO INDIRIZZO
		//comune
		//indirizzo
		//numero civico
		//cap
		Indirizzo indirizzoObj = new Indirizzo();
		indirizzoObj.setComune(comune);
		indirizzoObj.setIndirizzo(indirizzo);
		indirizzoObj.setNCivico(Integer.parseInt(numero_civico));
		indirizzoObj.setCap(cap);
		indirizzoService.save(indirizzoObj);
		
		annuncio.setIndirizzo(indirizzoObj);
		
		
		User utente = (User) request.getSession().getAttribute("loggedUser");
		annuncio.setUtente(utente);
		
		annuncioService.saveAnnuncio(annuncio);
		
		return "redirect:/";
	}
	
}