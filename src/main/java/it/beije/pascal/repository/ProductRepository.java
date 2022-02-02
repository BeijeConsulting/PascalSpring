package it.beije.pascal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.pascal.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
