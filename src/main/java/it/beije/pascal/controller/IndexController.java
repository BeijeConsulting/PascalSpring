package it.beije.pascal.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.pascal.model.Product;
import it.beije.pascal.model.User;
import it.beije.pascal.service.EcommerceService;

@Controller
public class IndexController {

	@Autowired
	private EcommerceService eCommerceService;

	@GetMapping(value = "/")
	public String index() {

		return "eCommerce/homeEcom"; // /WEB-INF/views/index.jsp

	}

	@PostMapping(value = "/registra")
	public String registra(@RequestParam String email, @RequestParam String password, @RequestParam String nome,
			@RequestParam String cognome, Model model) {

		eCommerceService.registra(email, password, nome, cognome);

		model.addAttribute("corretto", "Registrato! Ora puoi loggarti");
		return "eCommerce/homeEcom";

	}

	@PostMapping(value = "/login")
	public String login(@RequestParam String email, @RequestParam String password, Model model) {

		User user = eCommerceService.login(email, password);

		if (user != null) {
			model.addAttribute("utente", user);
			return "eCommerce/paginaLogin";
		} else {
			model.addAttribute("errore", "credenziali errate");
			return "eCommerce/homeEcom";
		}

	}

	@GetMapping(value = "/vediProdotti")
	public String vediProdotti(Model model) {

		List<Product> prodotti = eCommerceService.vediProdotti();

		model.addAttribute("prodotti", prodotti);
		return "eCommerce/vediProdotti"; // /WEB-INF/views/index.jsp

	}

}
