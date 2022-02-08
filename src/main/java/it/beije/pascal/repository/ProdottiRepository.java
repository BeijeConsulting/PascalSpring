package it.beije.pascal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.pascal.model.Product;

@Repository
public interface ProdottiRepository extends JpaRepository<Product, Integer> {

	List<Product> findByName(String name);

	Optional<Product> findById(Integer id);

	List<Product> findByNome(String nome);


}
