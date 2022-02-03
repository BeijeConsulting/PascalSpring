package it.beije.pascal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.pascal.model.RicercaSalvata;

@Repository
public interface RicercaSalvataRepository extends JpaRepository<RicercaSalvata, Integer>{

}
