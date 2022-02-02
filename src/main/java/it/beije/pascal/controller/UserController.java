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
	private UserService userService;

	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "loginHome";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginControl(Model model, @RequestParam String email, @RequestParam String password ) {
		System.out.println(email);
		System.out.println(password);
		
		User u = userService.findUser(email, password);

		return "redirect:/shopHome";
	}
	
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		return "registerHome";
	}
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerNewUser(@RequestParam String email, @RequestParam String password, @RequestParam String name, @RequestParam String surname) {
		
		User user = new User(email,name,surname,password);
		
		userService.register(user);
		
		return "redirect:/login";
	}
	
}
