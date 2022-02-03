package it.beije.pascal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.pascal.model.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer>{

	List<Utente> findByEmailAndPassword(String email, String password);

}
