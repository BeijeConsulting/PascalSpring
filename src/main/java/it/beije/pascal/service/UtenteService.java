package it.beije.pascal.service;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.pascal.model.User;
import it.beije.pascal.repository.UtenteRepository;

@Service
public class UtenteService {

	@Autowired
	UtenteRepository utenteRepository;
	
	public User login(String email, String password) throws Exception {
		User utente = null;

		List<User> uList = utenteRepository.findByEmailAndPassword(email, password);
		if(uList.size() != 1 ) throw new Exception("Utente non trovato");
		
		utente=uList.get(0);
		return utente;
	}

	public void save(User utente) {
		utenteRepository.save(utente);
	}
}
