package it.beije.pascal.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.pascal.model.Product;
import it.beije.pascal.service.ProductService;

@RestController
@RequestMapping("api")
public class ProductRestController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(value = "/getProducts")
	public List<Product> getList(){
		return productService.getList();
	}
	
	@GetMapping(value = "/getProduct/{name}")
	public Product getDetails(@PathVariable String name) {
		return productService.getDetails(name);
	}
	
	@PostMapping(value = "/addProduct")
	public Product insert(@RequestBody Product product) {
		return product;
	}

}
