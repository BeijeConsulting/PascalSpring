package it.beije.pascal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.pascal.model.User;
import it.beije.pascal.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public void register(User user) {
		userRepository.save(user);
	}
	
	public User findUser(String email, String password) {
		return userRepository.findUserByEmailAndPassword(email, password);
	}
	
}
