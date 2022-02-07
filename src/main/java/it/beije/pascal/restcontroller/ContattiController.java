package it.beije.pascal.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.pascal.model.Contatto;
import it.beije.pascal.repository.RubricaRepository;
import it.beije.pascal.service.RubricaService;


//@Controller
@RestController
public class ContattiController {

	@Autowired
	private RubricaService rubricaService;

	@Autowired
	private RubricaRepository rubricaRepository;

//	@RequestMapping(value = "/contatti", method = RequestMethod.GET)
//	public @ResponseBody List<Contatto> getList(@RequestParam(value = "surname", required = false) String cognome) {
	@GetMapping(value = "/contatti")
	public List<Contatto> getList(@RequestParam(value = "surname", required = false) String cognome) {
		System.out.println("GET contatti");
		
		List<Contatto> contatti = rubricaService.getList(cognome);

		System.out.println("contatti : " + contatti.size());
		
		return contatti;
	}
	
//	@RequestMapping(value = "/contatto/{id}", method = RequestMethod.GET)
//	public @ResponseBody Contatto getDetail(@PathVariable Integer id) {
	@GetMapping(value = "/contatto/{id}")
	public Contatto getDetail(@PathVariable Integer id) {
		System.out.println("GET contatto");
		
		Optional<Contatto> o = rubricaRepository.findById(id);
		
		return o.isPresent() ? o.get() : null;
	}
	
	@PostMapping(value = "/contatto")
	public Contatto insert(@RequestBody Contatto contatto) {
		System.out.println("POST contatto : " + contatto);
		
		rubricaRepository.save(contatto);
		
		return contatto;
	}

	@PutMapping(value = "/contatto/{id}")
	public Contatto insert(@RequestBody Contatto contatto, @PathVariable Integer id) {
		System.out.println("PUT contatto : " + contatto);
		
		Contatto c = null;
		if (contatto.getId() != null && contatto.getId() == id) {
			Optional<Contatto> o = rubricaRepository.findById(id);
			
			if (o.isPresent()) {
				c = o.get();
//				c.setCognome(contatto.getCognome());
//				c.setNome(contatto.getNome());
				//....
				BeanUtils.copyProperties(contatto, c);
				rubricaRepository.save(c);
			} else throw new RuntimeException("id errato");
		}		
		
		return c;
	}

	@DeleteMapping(value = "/contatto/{id}")
	public Boolean insert(@PathVariable Integer id) {
		System.out.println("DELETE contatto : " + id);
		
		Optional<Contatto> o = rubricaRepository.findById(id);
			
		if (o.isPresent()) {
				rubricaRepository.delete(o.get());
		} else throw new RuntimeException("id errato");
				
		return Boolean.TRUE;
	}

}
