package it.beije.pascal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.beije.pascal.model.Contatto;
import it.beije.pascal.model.Order;
import it.beije.pascal.model.Product;
import it.beije.pascal.repository.ProdottiRepository;
import it.beije.pascal.repository.RubricaRepository;

public class ProdottiService {
	
	@Autowired
	private ProdottiRepository prodottiRepository;
	
	public List<Product> getList(){
		return getList(null);
	}
	
	public List<Product> getList(String nome) {
		List<Product> prodotti = nome != null ? prodottiRepository.findByNome(nome) : prodottiRepository.findAll();
		return prodotti;
	}

}
