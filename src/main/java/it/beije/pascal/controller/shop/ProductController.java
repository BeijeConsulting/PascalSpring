package it.beije.pascal.controller.shop;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.pascal.model.Product;
import it.beije.pascal.service.shop.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public String product_list(Model model) {
		
		List<Product> product_list = new ArrayList<>();
		
		product_list = productService.getList();
				
		model.addAttribute("list",product_list);
		
		return "list_product";
	}
	
	
	
}
