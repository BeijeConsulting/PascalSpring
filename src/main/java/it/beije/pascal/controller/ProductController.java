package it.beije.pascal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.pascal.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String showContatti(Model model) {

		model.addAttribute("products", productService.findAll());

		return "shopHome";
	}

	
}
