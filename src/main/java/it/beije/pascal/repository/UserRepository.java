package it.beije.pascal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.pascal.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	
	public User findUserByEmailAndPassword(String email, String password);
}
