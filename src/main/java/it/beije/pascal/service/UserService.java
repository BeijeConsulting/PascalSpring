package it.beije.pascal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.pascal.model.User;
import it.beije.pascal.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getList(){
		List<User> users = userRepository.findAll();
		return users;
	}
	
	public User getDetail(Integer id) {
		return userRepository.findById(id).get();
	}
	
	public User insert(User user) {
		return userRepository.save(user);
	}
	
	public User insert(User user, Integer id) {
		return userRepository.findById(id).get();
	}
	
	public Boolean delete(User u) {
		userRepository.delete(u);
		return true;
	}

}
