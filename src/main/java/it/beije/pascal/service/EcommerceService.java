package it.beije.pascal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.pascal.model.Product;
import it.beije.pascal.model.User;
import it.beije.pascal.repository.ProductRepository;
import it.beije.pascal.repository.UserRepository;

@Service
public class EcommerceService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public User login(String email, String password) {
		User user = userRepository.findByEmailAndPassword(email, password);
		
		if(user != null) {
			return user;
		}
		else {
			return null;
		}
		
	}
	
	public List<Product> vediProdotti(){
		return productRepository.searchProduct();
		
	}
	
	public void registra(@RequestParam String email, @RequestParam String password, @RequestParam String nome, @RequestParam String cognome){
		User u = new User();
		u.setEmail(email);
		u.setName(nome);
		u.setPassword(password);
		u.setSurname(cognome);
		
		userRepository.save(u);
		
	}

}
