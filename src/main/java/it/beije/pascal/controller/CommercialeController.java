package it.beije.pascal.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.pascal.model.Commerciale;
import it.beije.pascal.service.CommercialeService;

@Controller
public class CommercialeController {
	
	@Autowired
	CommercialeService commercialeService;
	
	@RequestMapping(value = "commercialeLogin", method = RequestMethod.GET)	
	public String commercialLogin(HttpSession session, @RequestParam String email, @RequestParam String password) {
		Commerciale loggedCommercial = commercialeService.commercialLogin(email, password) ;
		session.setAttribute("loggedCommercial", loggedCommercial);
		
		// TODO cambaiare in homepage
		return "index";		
	}
	
	public String commercialLogut(HttpSession session) {
		session.removeAttribute("loggedCommercial");
		
		// TODO cambaiare in homepage
				return "index";
		
	}
	
	

}
