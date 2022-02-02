package it.beije.pascal.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.pascal.model.Order;
import it.beije.pascal.model.Product;
import it.beije.pascal.model.User;
import it.beije.pascal.service.EcommerceDbService;

@Controller
public class EcommerceController {
	
	@Autowired
	EcommerceDbService dbService;

	@RequestMapping(value="goto_login", method = RequestMethod.GET)
	public String serveLogin() {
		return "ecommerce_login";
	}
	
	@RequestMapping(value="goto_register", method = RequestMethod.GET)
	public String serveRegistration() {
		return "ecommerce_register";
	}
	
	@RequestMapping(value="ecommerce", method = RequestMethod.GET)
	public String serveHomepage() {
		return "ecommerce_home";
	}
	
	@RequestMapping(value="ecomLogin", method = RequestMethod.POST)
	public String userLogin(Model model, HttpServletRequest request, @RequestParam String email, @RequestParam String password) {
		User loggedUser = null;
		
		try {
			loggedUser = dbService.login(email, password);
			request.getSession().setAttribute("loggedUser", loggedUser);
			
		} catch (Exception e) {
			System.out.println("Failed to login");
			e.printStackTrace();
			return "ecommerce_login";
		}
		
		return "ecommerce_home";
	}
	
	@RequestMapping(value="ecomRegister", method = RequestMethod.POST)
	public String register(Model model, @RequestParam String name, @RequestParam String surname,  @RequestParam String email, @RequestParam String password) {
		
		User user = new User(name, email, surname, password);
		dbService.register(user);
		
		return "ecommerce_login";
	}
	
	@RequestMapping(value="ecomSearch", method = RequestMethod.GET)
	public String searchProduct(Model model,@RequestParam String name) {
		
		List<Product> risultati = dbService.searchProduct(name);
		model.addAttribute("searchResults", risultati);
		
		return "ecommerce_list";
	}
	
	@RequestMapping(value="ecomAddToOrder", method = RequestMethod.GET)
	public String addToOrder(Model model, HttpServletRequest request,@RequestParam Integer amt, @RequestParam Integer itemId, @RequestParam Double price) {
		//TODO
		Order currentOrder = (Order) request.getSession().getAttribute("currentOrder");
		User loggedUser = (User) request.getSession().getAttribute("loggedUser");

		if(loggedUser == null) {
			return"ecommerce_login";
		}
		if(currentOrder==null) {
			currentOrder = new Order();
			currentOrder.setUser(loggedUser);
		}
		
//		OrderItem item = new OrderItem(null, currentOrder.getId(), itemId, price, amt);
		//TODO

		request.getSession().setAttribute("currentOrder", currentOrder);
		return "ecommerce_home";
	}
	
	@RequestMapping(value="ecomViewProduct", method = RequestMethod.GET)
	public String viewProduct(Model model, @RequestParam Integer productId) {
		
		Product product = dbService.fetchProduct(productId).get();
		model.addAttribute("product", product);
		
		//TODO sposta tutto su un solo html
		return "ecommerce_home";
	}
}
