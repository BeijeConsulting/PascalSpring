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

	@RequestMapping(value = "/formLoginCommerciale", method = RequestMethod.GET)
	public String formLogin() {
		return "login_commerciale";
	}

	@RequestMapping(value = "commercialeLogin", method = RequestMethod.POST)
	public String commercialLogin(HttpSession session, @RequestParam String email, @RequestParam String password) {
		Commerciale loggedCommercial = null;
		try {
			loggedCommercial = commercialeService.commercialLogin(email, password);
			session.setAttribute("loggedUser", loggedCommercial);
			//System.out.println(loggedCommercial.getEmail() + " " + loggedCommercial.getPassword());
		} catch (Exception e) {
			//System.out.println("credenziali sbagliate");
			return "index";
		}
		

		// TODO cambaiare in homepage
		return "index";
	}

	public String commercialLogut(HttpSession session) {
		session.removeAttribute("loggedCommercial");

		// TODO cambaiare in homepage
		return "index";

	}

}
