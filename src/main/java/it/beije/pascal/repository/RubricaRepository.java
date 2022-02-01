package it.beije.pascal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.pascal.model.Contatto;


@Repository
public interface RubricaRepository extends JpaRepository<Contatto, Integer> {
	
	public List<Contatto> findByCognome(String cognome);

	public List<Contatto> findByNomeAndCognome(String nome, String cognome);

}
