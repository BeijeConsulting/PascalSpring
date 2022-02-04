package it.beije.pascal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.pascal.model.Commerciale;
import it.beije.pascal.repository.CommercialeRepository;

@Service
public class CommercialeService {
	
	@Autowired
	private CommercialeRepository commercialeRepository;

	public void insertCommerciale(Commerciale commerciale) {
		commercialeRepository.save(commerciale);
	}
	
	public Commerciale commercialLogin(String email, String password) {
		Commerciale commerciale = commercialeRepository.findByEmailAndPassword(email, password);
		return commerciale;
	}
	
	
}
