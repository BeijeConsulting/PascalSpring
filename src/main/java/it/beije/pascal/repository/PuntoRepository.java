package it.beije.pascal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.pascal.model.Punto;

public interface PuntoRepository extends JpaRepository<Punto, Integer> {

}
