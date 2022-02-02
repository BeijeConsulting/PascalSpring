package it.beije.pascal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.pascal.repository.UserRepository;


@Service
public class UserService {

	
	@Autowired
	private UserRepository userRepository;
	
}
