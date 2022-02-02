package it.beije.pascal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.pascal.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@RequestMapping(value = "/ecommerce", method = RequestMethod.GET)
	public String getEcommerce(Model model) {
		return "ecommerce/ecommerce";
	}
	
	@RequestMapping(value = "/registration_form", method = RequestMethod.GET)
	public String getRegistrationForm() {			
		return"ecommerce/registration";		
	}
	
//	@RequestMapping(value = "/users", method = RequestMethod.GET)
//	public String getUserList(Model model) {
//		List<User> users = userRepository.findAll();	
//		model.addAttribute("users", users);
//		return "ecommerce/lista_utenti";
//	}	
		
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@RequestParam String nome,  @RequestParam String cognome,  @RequestParam String email,  @RequestParam String password) {	
		
	
		return"ecommerce/ecommerce";
		
	}

}
