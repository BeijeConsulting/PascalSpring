package it.beije.pascal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.pascal.model.User;

@Repository
public interface UtenteRepository extends JpaRepository<User, Integer>{

	List<User> findByEmailAndPassword(String email, String password);

}
