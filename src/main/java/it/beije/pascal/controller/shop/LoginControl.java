package it.beije.pascal.controller.shop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginControl {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
	
		return "login_shop";
	}
	
	@RequestMapping(value = "/log", method = RequestMethod.POST)
	public String log(Model model) {
	
		return "";
	}

}
