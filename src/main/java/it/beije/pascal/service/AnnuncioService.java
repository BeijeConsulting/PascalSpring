package it.beije.pascal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.pascal.model.Annuncio;
import it.beije.pascal.repository.AnnuncioRepository;

@Service
public class AnnuncioService {
	
	@Autowired
	private AnnuncioRepository annuncioRepository;
	
	public List<Annuncio> findAllAnnunci() {
		return annuncioRepository.findAll();
	}
	
	public Optional<Annuncio> getOneAnnuncio(Integer id) {
		return annuncioRepository.findById(id);
	}
//	
//	public List<Annuncio> metodo(String tipoAnnuncio, String tipoImmobile, String comune) {
//		return annuncioRepository.findAllByTipoImmobileAndTipoAnnuncioAndIndirizzo_Comune(tipoImmobile, tipoAnnuncio, comune);
//	}
	
	public void saveAnnuncio(Annuncio annuncio) {
		annuncioRepository.save(annuncio);
	}
}