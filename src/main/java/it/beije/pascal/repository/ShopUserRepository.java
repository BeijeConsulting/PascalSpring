package it.beije.pascal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.pascal.model.User;


@Repository
public interface ShopUserRepository extends JpaRepository<User, Integer> {
	
	public List<User> findByEmailAndPassword(String email, String password);


}