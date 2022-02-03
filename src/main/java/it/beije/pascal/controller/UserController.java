package it.beije.pascal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.pascal.model.User;
import it.beije.pascal.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;	
	
	
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
		User user = new User(email,nome,cognome,password);
		userService.save(user);	
		return"ecommerce/ecommerce";		
	}
}
