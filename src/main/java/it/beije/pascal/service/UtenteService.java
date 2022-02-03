package it.beije.pascal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.pascal.model.Utente;
import it.beije.pascal.repository.UtenteRepository;

@Service
public class UtenteService {
	
	@Autowired
	UtenteRepository utenteRepository;
	
	
	public void save(Utente utente) {
		utenteRepository.save(utente);
		
	}

}
