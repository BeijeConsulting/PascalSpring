package it.beije.pascal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.pascal.model.Annuncio;
import it.beije.pascal.repository.AnnuncioRepository;

@Service
public class RicercaService {
	
	@Autowired 
	private AnnuncioRepository annuncioRepository;
	
	public List<Annuncio> search(String tipoAnnuncio, String tipoImmobile, String comune) {
		return annuncioRepository.searchAnnuncio(tipoImmobile, tipoAnnuncio, comune);
	}
	
}
