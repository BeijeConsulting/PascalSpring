package it.beije.pascal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.pascal.model.Product;
import it.beije.pascal.repository.ProdottiRepository;

@Service
public class ProdottiService {
	
	@Autowired
	private ProdottiRepository prodottiRepository;
	
	public List<Product> getList(){
		return getList(null);
	}
	
	public List<Product> getList(String nome) {
		List<Product> prodotti = nome != null ? prodottiRepository.findByName(nome) : prodottiRepository.findAll();
		return prodotti;
	}

}
