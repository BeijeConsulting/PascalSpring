package it.beije.pascal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.pascal.model.Agenzia;

@Repository
public interface AgenziaRepository extends JpaRepository<Agenzia, Integer>{

}
