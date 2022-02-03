package it.beije.pascal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.pascal.model.Annuncio;

public interface AnnuncioRepository extends JpaRepository<Annuncio, Integer> {

}
