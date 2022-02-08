package it.beije.pascal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.beije.pascal.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
