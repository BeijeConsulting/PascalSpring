package it.beije.pascal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.pascal.model.User;
import it.beije.pascal.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User register(User user) {
		return userRepository.save(user);
	}

	public User findUser(String email, String password) {
		return userRepository.findUserByEmailAndPassword(email, password);
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public Optional<User> findById(Integer id) {
		return userRepository.findById(id);
	}

	public User update(User p, User User, Integer id) {
		User.setId(id);
		BeanUtils.copyProperties(User, p);
		return register(User);
	}

	public void delete(User p) {
		userRepository.delete(p);
	}

}
