package it.beije.pascal.controller.shop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginControl {
	
	@GetMapping(value = "/")
	public String index(Model model) {
		
		return "shop_main"; // /WEB-INF/views/shop_main.jsp
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
	
		return "login_shop";
	}
	
	@RequestMapping(value = "/log", method = RequestMethod.POST)
	public String log(Model model) {
	
		return "";
	}

}
