package it.beije.pascal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.pascal.model.Indirizzo;
import it.beije.pascal.model.Utente;
import it.beije.pascal.repository.IndirizzoRepository;
import it.beije.pascal.repository.UtenteRepository;

@Service
public class IndirizzoService {
	@Autowired
	IndirizzoRepository indirizzoRepository;

	
	public void save(Indirizzo indirizzo) {
		indirizzoRepository.save(indirizzo);
		}
}
