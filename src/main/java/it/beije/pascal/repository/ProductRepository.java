package it.beije.pascal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.pascal.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
