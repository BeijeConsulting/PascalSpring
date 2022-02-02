package it.beije.pascal.service.shop;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.beije.pascal.model.Product;
import it.beije.pascal.repository.shop.ProductRepository;

@Service
public class ProductService {
	
	@GetMapping(value = "/")
	public String index(Model model) {
		
		return "shop_main"; // /WEB-INF/views/shop_main.jsp
	}
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getList(){
		
		List<Product> pList = new ArrayList<>();
		
		pList = productRepository.findAll();
		
		return pList;
		
	}
	

}
