package it.beije.pascal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.pascal.model.Contatto;
import it.beije.pascal.repository.ContattoRepository;

@Service
public class ContattoService {
	
	@Autowired
	private ContattoRepository contattoRepository;
	
	
	public List<Contatto> findAll() {
		return contattoRepository.findAll();
	}
	
	public void insertContatto(Contatto contatto) {
		contattoRepository.save(contatto);
	}
	
	public void deleteContatto(Integer id) {
		contattoRepository.deleteById(id);
	}
	
	public Optional<Contatto> getContatto(Integer id) {
		return contattoRepository.findById(id);
	}
	
	public void updateContatto(Integer id) {
	}
}
