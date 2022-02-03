package it.beije.pascal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.pascal.model.Utente;
import it.beije.pascal.repository.UtenteRepository;

@Service
public class UtenteService {
	@Autowired
	UtenteRepository utenterepository;
	
	public Utente login(String email, String password) throws Exception {
		Utente utente = null;
		
		List<Utente> uList = utenterepository.findByEmailAndPassword(email, password);
		if(uList.size() != 1 ) throw new Exception("Utente non trovato");
		
		utente=uList.get(0);
		return utente;
	}
}
