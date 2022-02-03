package it.beije.pascal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.pascal.model.Annuncio;

@Repository
public interface AnnuncioRepository extends JpaRepository<Annuncio, Integer> {

}
