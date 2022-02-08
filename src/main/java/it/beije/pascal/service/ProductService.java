package it.beije.pascal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import it.beije.pascal.model.Product;
import it.beije.pascal.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Optional<Product> findById(Integer id) {
		return productRepository.findById(id);
	}

	public Product save(Product product) {
		return productRepository.save(product);
	}

	public Product update(Product p, Product product, Integer id) {
		product.setId(id);
		BeanUtils.copyProperties(product, p);
		return save(product);
	}

	public void delete(Product p) {
		productRepository.delete(p);
	}
}
