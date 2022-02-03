package it.beije.pascal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.pascal.model.Punto;

@Repository
public interface PuntoRepository extends JpaRepository<Punto, Integer> {

}
