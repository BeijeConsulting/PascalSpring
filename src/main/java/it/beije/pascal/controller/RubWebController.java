package it.beije.pascal.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.pascal.model.Contatto;
import it.beije.pascal.service.ContattoService;

@Controller
public class RubWebController {

	@Autowired
	private ContattoService contattoService;
	
	//autowired service
	
	@RequestMapping(value = "/webRubrica", method = RequestMethod.GET)
	public String showContatti(Model model) {
		
		model.addAttribute("contatti", contattoService.findAll());
		
		return "rubricaHomepage";
	}
	
	@RequestMapping(value = "/webInsertContatto", method = RequestMethod.GET)
	public String insertCont() {
		return "inserisciContatto";
	}
	
	@RequestMapping(value = "/webInsertContatto", method = RequestMethod.POST)
	public String postCont(@RequestParam String nome, @RequestParam String cognome, @RequestParam String email, @RequestParam String telefono, @RequestParam String note) {
		
		Contatto cont = new Contatto();
		cont.setNome(nome);
		cont.setCognome(cognome);
		cont.setEmail(email);
		cont.setTelefono(telefono);
		cont.setNote(note);
		
		contattoService.insertContatto(cont);
		
		return "redirect:/webRubrica";
	}
	
	@RequestMapping(value = "/webDeleteContatto", method = RequestMethod.POST)
	public String del(@RequestParam Integer id) {
		
		contattoService.deleteContatto(id);
		
		return "redirect:/webRubrica";
	}
	
	@RequestMapping(value = "/webUpdateContatto", method = RequestMethod.GET)
	public String update(Model model, @RequestParam Integer id) {
		
		Optional<Contatto> c = contattoService.getContatto(id);
		model.addAttribute("contatto", c);
		
		return "updateContatto";
	}
	
	@RequestMapping(value = "/webUpdateContatto", method = RequestMethod.POST)
	public String updatePost(@RequestParam Integer id, @RequestParam String nome, @RequestParam String cognome, @RequestParam String email, @RequestParam String telefono, @RequestParam String note) {
		
		return "redirect:/webRubrica";
	}
	
	
}
