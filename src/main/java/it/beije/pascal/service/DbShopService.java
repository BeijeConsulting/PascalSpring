package it.beije.pascal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.pascal.model.*;

import it.beije.pascal.repository.ShopUserRepository;
import it.beije.pascal.repository.ShopProductRepository;

@Service
public class DbShopService {
	
	@Autowired
	private ShopUserRepository userRepository;
	
	@Autowired
	private ShopProductRepository productRepository;
	
	public User login(String email, String password) throws Exception {
		User user = null;
		
		List<User> userList = userRepository.findByEmailAndPassword(email, password);
		if(userList.size() != 1 ) throw new Exception("Utente non trovato");
		
		user=userList.get(0);
		return user;
	}
	
	public void register(User user) {
		userRepository.save(user);
	}

	public List<Product> searchProduct(String name) {
		return productRepository.findByName(name);
	}
	
	
}