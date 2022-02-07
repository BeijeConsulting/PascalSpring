package it.beije.pascal.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.beije.pascal.model.Contatto;
import it.beije.pascal.model.Product;
import it.beije.pascal.service.ContattoService;
import it.beije.pascal.service.ProductService;

@RestController
public class ShopControllerWS {

	@Autowired
	private ContattoService contattoService;
	
	@Autowired
	private ProductService productService;
	
	
	@GetMapping(value = "/cont")
	public List<Contatto> getList() {
		System.out.println("GET contatti");
		
		List<Contatto> contatti = contattoService.findAll();

		System.out.println("contatti : " + contatti.size());
		
		return contatti;
	}
	
	
	@GetMapping(value = "/pro")
	public List<Product> getItems() {
		System.out.println("GET Items");
		
		List<Product> products = productService.findAll();

		System.out.println("contatti : " + products.size());
		
		return products;
	}
	
	
	@GetMapping(value = "/pro/{id}")
	public Product getItemDetails(@PathVariable Integer id) {
		System.out.println("GET details prd");
		
		Optional<Product> o = productService.findById(id);
		
		return o.isPresent() ? o.get() : null;
	}	
	
}
