package it.beije.pascal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.pascal.model.Contatto;
import it.beije.pascal.repository.RubricaRepository;

@Controller
public class DbController {

	@Autowired
	private RubricaRepository rubricaRepository;

	@RequestMapping(value = "/rubrica", method = RequestMethod.GET)
	public String rubrica(Model model) {
		return "rubricadb";
	}

	@RequestMapping(value = "/contact_list", method = RequestMethod.GET)
	public String getContactList(Model model) {
		List<Contatto> contatti = rubricaRepository.findAll();
		model.addAttribute("contatti", contatti);
		return "rubrica/lista_contatti";
	}

	@RequestMapping(value = "get_contatto", method = RequestMethod.GET)
	public String getContact(Model model) {
		Optional<Contatto> contatto = rubricaRepository.findById(2);
		model.addAttribute("contatto", contatto);
		return "rubrica/get_contatto";
	}
}
