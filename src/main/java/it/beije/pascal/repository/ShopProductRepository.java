package it.beije.pascal.repository;

import java.util.List;

import it.beije.pascal.model.Product;

public interface ShopProductRepository {

	List<Product> findByName(String name);

}
