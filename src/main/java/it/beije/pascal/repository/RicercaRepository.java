package it.beije.pascal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.pascal.model.Ricerca;

@Repository
public interface RicercaRepository extends JpaRepository<Ricerca, Integer>{

}
