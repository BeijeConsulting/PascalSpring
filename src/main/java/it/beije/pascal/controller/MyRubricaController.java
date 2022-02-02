package it.beije.pascal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.pascal.model.Contatto;
import it.beije.pascal.repository.RubricaRepository;

@Controller
public class MyRubricaController {
	
	@Autowired
	private RubricaRepository rubricaRepository;
	
	@GetMapping(value="/")
	public String rubricaIndex() {
		return "my_rubrica";
	}
	
	@RequestMapping(value = "/rubricaListAll", method = RequestMethod.GET)
	public String listAll(Model model, @RequestParam String orderBy, @RequestParam String ascDesc) {
		
		List<Contatto> cList;
		
		switch(orderBy){
			case "nome": 
				switch(ascDesc) {
				default:
				case "asc": cList = rubricaRepository.findAllByOrderByNomeAsc(); break;
				case "desc": cList = rubricaRepository.findAllByOrderByNomeDesc(); break;
				} break;
			case "cognome":
				switch(ascDesc) {
				default:
				case "asc": cList = rubricaRepository.findAllByOrderByCognomeAsc(); break;
				case "desc": cList = rubricaRepository.findAllByOrderByCognomeDesc(); break;
				} break;
			default: cList = rubricaRepository.findAll(); break;
		}
		
		
		
		model.addAttribute("listaContatti", cList);
		return"tabellaContatti";
	}
	
	@RequestMapping(value = "/rubricaListWithEmail", method = RequestMethod.GET)
	public String listWithEmail(Model model) {
		List<Contatto> cList = rubricaRepository.findByEmailNotNull();
		
		model.addAttribute("listaContatti", cList);
		return"tabellaContatti";
	}
	
	@RequestMapping(value = "/rubricaListWithTelefono", method = RequestMethod.GET)
	public String listWithTelefono(Model model) {
		List<Contatto> cList = rubricaRepository.findByTelefonoNotNull();
		
		model.addAttribute("listaContatti", cList);
		return"tabellaContatti";
	}
	
	@RequestMapping(value = "/rubricaCercaNomeCognome", method = RequestMethod.GET)
	public String cercaNomeCognome(Model model, @RequestParam String nome, @RequestParam String cognome) {
		List<Contatto> cList = rubricaRepository.findByNomeAndCognome(nome, cognome);

		
		model.addAttribute("listaContatti", cList);
		return"tabellaContatti";
	}
	
	@RequestMapping(value = "/rubricaInsertContatto", method = RequestMethod.GET)
	public String insertContatto(Model model, @RequestParam String nome, @RequestParam String cognome, 
				@RequestParam String telefono,@RequestParam String email, @RequestParam String note) {
		
		Contatto c = new Contatto();
		c.setCognome(cognome);
		c.setNome(nome);
		c.setEmail(email);
		c.setTelefono(telefono);
		c.setNote(note);
		
		System.out.println("Contatto PRE: " + c);
		rubricaRepository.save(c);
		System.out.println("Contatto POST: " + c);
		
		return "my_rubrica";
	}
	
	
}
