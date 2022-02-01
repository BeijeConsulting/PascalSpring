package it.beije.pascal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.pascal.model.Contatto;
import it.beije.pascal.repository.ContattoRepository;
import it.beije.pascal.repository.RubricaRepository;

@Service
public class ContattoService {
	
	@Autowired
	private ContattoRepository contattoRepository;

	//get di tutti i contatti
	public List<Contatto> findAll() {
		return contattoRepository.findAll();
	}
	
	//insert contatto
	public void insertContatto(Contatto cont) {
		contattoRepository.save(cont);
	}
	
	public void deleteContatto(Integer id) {
		contattoRepository.deleteById(id);
	}
	
	public Optional<Contatto> getContatto(Integer id) {
		return contattoRepository.findById(id);
	}
}
