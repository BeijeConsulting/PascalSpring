package it.beije.pascal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.pascal.model.User;

public interface EcommerceUserRepository extends JpaRepository<User, Integer>{
	
	public List<User> findByEmailAndPassword(String email, String password);

}
