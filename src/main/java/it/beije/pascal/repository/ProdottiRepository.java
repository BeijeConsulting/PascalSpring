package it.beije.pascal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.pascal.model.Contatto;
import it.beije.pascal.model.Product;

public interface ProdottiRepository extends JpaRepository<Product, Integer> {

	List<Product> findByName(String name);

	Optional<Product> findById(Integer id);

	List<Product> findByNome(String nome);


}
