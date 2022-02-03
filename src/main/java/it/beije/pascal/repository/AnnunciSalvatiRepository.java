package it.beije.pascal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.pascal.model.AnnunciSalvati;

 @Repository
public interface AnnunciSalvatiRepository extends JpaRepository<AnnunciSalvati, Integer>{

}
