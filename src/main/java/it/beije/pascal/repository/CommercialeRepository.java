package it.beije.pascal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.pascal.model.Commerciale;

@Repository
public interface CommercialeRepository extends JpaRepository<Commerciale, Integer> {
	
	public Commerciale findByEmailAndPassword(String email, String password);
}
