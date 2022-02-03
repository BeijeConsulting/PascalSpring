package it.beije.pascal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.pascal.model.Foto;

@Repository
public interface FotoRepository extends JpaRepository<Foto, Integer> {

}
