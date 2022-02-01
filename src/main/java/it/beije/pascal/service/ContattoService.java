package it.beije.pascal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.pascal.model.Contatto;
import it.beije.pascal.repository.RubricaRepository;

@Service
public class ContattoService {
	
	@Autowired
	private RubricaRepository rubricaRepo;

	//get di tutti i contatti
	public List<Contatto> findAll() {
		return rubricaRepo.findAll();
	}
	
	

}
