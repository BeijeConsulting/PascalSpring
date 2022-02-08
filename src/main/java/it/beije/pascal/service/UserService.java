package it.beije.pascal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.pascal.model.User;
import it.beije.pascal.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void save(User user) {
		userRepository.save(user);
	}

	public User findById(Integer id) {
		Optional<User> o = userRepository.findById(id);
		if (o.isPresent()) {
			User user = o.get();
			return user;
		} else {
			return null;
		}
	}

	public Boolean delete(Integer id) {
		Optional<User> optional = userRepository.findById(id);
		if (optional.isPresent()) {
			User user = optional.get();
			userRepository.delete(user);
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}
}
