package it.beije.pascal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.pascal.model.*;
import it.beije.pascal.repository.EcommerceProductRepository;
import it.beije.pascal.repository.EcommerceUserRepository;

@Service
public class EcommerceDbService {
	
	@Autowired
	private EcommerceUserRepository userRepository;
	
	@Autowired
	private EcommerceProductRepository productRepository;
	
	public User login(String email, String password) throws Exception {
		User user = null;
		
		List<User> uList = userRepository.findByEmailAndPassword(email, password);
		if(uList.size() != 1 ) throw new Exception("Utente non trovato");
		
		user=uList.get(0);
		return user;
	}
	
	public void register(User user) {
		userRepository.save(user);
	}

	public List<Product> searchProduct(String name) {
		return productRepository.findByName(name);
	}

	public Optional<Product> fetchProduct(Integer productId) {
//		return productRepository.getOne(productId);
		return productRepository.findById(productId);
	}
	
	
}
