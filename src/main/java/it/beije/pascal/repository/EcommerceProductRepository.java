package it.beije.pascal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.pascal.model.Product;

public interface EcommerceProductRepository extends JpaRepository<Product, Integer>{
	
	public List<Product> findByName(String name);
}
