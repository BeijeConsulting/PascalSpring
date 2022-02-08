package it.beije.pascal.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.pascal.model.Contatto;
import it.beije.pascal.model.Product;
import it.beije.pascal.service.ProductService;

@RestController
@RequestMapping("api")
public class ProductRestController {

	@Autowired
	private ProductService productService;

	@GetMapping(value = "/products")
	public List<Product> getItems() {
		System.out.println("GET products");

		List<Product> products = productService.findAll();

		System.out.println("contatti : " + products.size());

		return products;
	}

	@GetMapping(value = "/product/{id}")
	public Product getItemDetails(@PathVariable Integer id) {
		System.out.println("GET details prd");

		Optional<Product> o = productService.findById(id);

		return o.isPresent() ? o.get() : null;
	}

	@PostMapping(value = "/product")
	public Product addNewProduct(@RequestBody Product product) {
		System.out.println("POST new prod");

		System.out.println(product);

		Product p = productService.save(product);

		return p;
	}

	@PutMapping(value = "/product/{id}")
	public Product modifyProduct(@PathVariable Integer id, @RequestBody Product product) {
		System.out.println("UPDATE prod");

		Optional<Product> o = productService.findById(id);

		if (o.isPresent()) {
			Product p = o.get();
			return productService.update(p, product, id);
		}

		return null;
	}

	@DeleteMapping(value = "/product/{id}")
	public void deleteProduct(@PathVariable Integer id) {
		System.out.println("DELETE product");

		Optional<Product> o = productService.findById(id);

		if (o.isPresent()) {
			Product p = o.get();
			productService.delete(p);
		}
	}

}
