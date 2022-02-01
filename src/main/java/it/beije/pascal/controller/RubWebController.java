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

	@RequestMapping(value = "/webrubrica", method = RequestMethod.GET)
	public String showContatti(Model model) {

		model.addAttribute("contatti", contattoService.findAll());

		return "rubricaHome";
	}

	@RequestMapping(value = "/webinsertContatto", method = RequestMethod.POST)
	public String insertContatto(Model model, @RequestParam String nome, @RequestParam String cognome,
			@RequestParam String email, @RequestParam String telefono, @RequestParam String note) {

		Contatto cont = new Contatto();
		cont.setNome(nome);
		cont.setCognome(cognome);
		cont.setEmail(email);
		cont.setTelefono(telefono);
		cont.setNote(note);

		contattoService.insertContatto(cont);
		return "redirect:/webrubrica";
	}

	@RequestMapping(value = "/webinsertContatto", method = RequestMethod.GET)
	public String insertContatto() {
		return "inserisciContatto";
	}
	
	
	@RequestMapping(value = "/webdeleteContatto", method = RequestMethod.POST)
	public String deleteContatto(@RequestParam Integer id) {

		contattoService.deleteContatto(id);
		
		
		return "redirect:/webrubrica";
	}
	
	@RequestMapping(value = "/webupdateContatto", method = RequestMethod.GET)
	public String updateContatto(Model model, @RequestParam Integer id) {

		Optional<Contatto> c = contattoService.getContatto(id);
		
		model.addAttribute("contattO", c);
		
		return "updateContatto";
	}
	
	@RequestMapping(value = "/webupdateContatto", method = RequestMethod.POST)
	public String updateContatto( @RequestParam String nome, @RequestParam String cognome,
			@RequestParam String email, @RequestParam String telefono, @RequestParam String note) {

		
		
		return "redirect:/webrubrica";
	}
}
