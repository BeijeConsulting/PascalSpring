package it.beije.pascal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.beije.pascal.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	@Query(nativeQuery = true, value = "SELECT * FROM Product")
	public List<Product> searchProduct();

}
