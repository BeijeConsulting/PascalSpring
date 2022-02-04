package it.beije.pascal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.pascal.model.Commerciale;
import it.beije.pascal.model.Indirizzo;
import it.beije.pascal.model.Utente;
import it.beije.pascal.repository.IndirizzoRepository;
import it.beije.pascal.service.CommercialeService;
import it.beije.pascal.service.IndirizzoService;
import it.beije.pascal.service.UtenteService;

@Controller
public class UtenteController {

	@Autowired
	UtenteService utenteService;

	@Autowired
	CommercialeService commercialeService;
	

	@Autowired
	IndirizzoService indirizzoService;

//	@GetMapping(value = "/")
//	public String homepage() {
//		// TODO cambia in homepage
//		return "index";
//	}

	@RequestMapping(value = "/form_privato", method = RequestMethod.GET)
	public String formPrivate() {
		return "registrazione_privato";

	}

	@RequestMapping(value = "/form_agenzia", method = RequestMethod.GET)
	public String formAgency() {
		return "registrazione_agenzia";
	}

	@RequestMapping(value = "/form_costruttore", method = RequestMethod.GET)
	public String formCostruttore() {
		return "registrazione_costruttore";
	}

	@RequestMapping(value = "/form_login", method = RequestMethod.GET)
	public String formLogin() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String userLogin(Model model, HttpServletRequest request, @RequestParam String email,
			@RequestParam String password) {

		Utente loggedUser = null;

		try {
			loggedUser = utenteService.login(email, password);
			request.getSession().setAttribute("loggedUser", loggedUser);

		} catch (Exception e) {
			System.out.println("Failed to login");
			e.printStackTrace();
			return "login";
		}

		return "homepage";
	}

	@RequestMapping(value = "/registrazione_privato", method = RequestMethod.POST)
	public String registerPrivate(@RequestParam(required = false) String username, String email, String password,
			String spam) {
		Utente utente = null;
		if (spam == null) {
			utente = new Utente(email, password, (byte) 0, username);
		} else {
			utente = new Utente(email, password, (byte) 1, username);
		}
		utenteService.save(utente);
		return "login";
	}

	@RequestMapping(value = "/registerAgenzia", method = RequestMethod.POST)
	public String registerAgenzia(Model model, @RequestParam String pIva, @RequestParam String ragioneSociale,
			@RequestParam String telefono, @RequestParam String cap, @RequestParam String comune,
			@RequestParam String indirizzo, @RequestParam Integer nCivico) {

		Indirizzo ind = new Indirizzo();
		ind.setCap(cap);
		ind.setComune(comune);
		ind.setNCivico(nCivico);
		ind.setIndirizzo(indirizzo);

		Commerciale comm = new Commerciale();

		comm.setPIva(pIva);
		comm.setRagioneSociale(ragioneSociale);
		comm.setTelefono(telefono);

		indirizzoService.save(ind);
		comm.setIndirizzo(ind);

		commercialeService.insertCommerciale(comm);

		// TODO cambia reindirizzamento
		return "login";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logOut(Model model, HttpServletRequest request) {
		try {
			request.getSession().removeAttribute("loggedUser");

		} catch (Exception e) {
			System.out.println("Failed to login");
			e.printStackTrace();
		}
		return "index.jsp";

	}

	@RequestMapping(value = "/registerCostruttore", method = RequestMethod.POST)
	public String registerCostruttore(Model model, @RequestParam String nomeRef, @RequestParam String cognomeRef,
			@RequestParam String ragioneSociale, @RequestParam String telefono, @RequestParam String cap,
			@RequestParam String comune, @RequestParam String indirizzo, @RequestParam Integer nCivico) {

		Indirizzo ind = new Indirizzo();
		ind.setCap(cap);
		ind.setComune(comune);
		ind.setNCivico(nCivico);
		ind.setIndirizzo(indirizzo);

		Commerciale comm = new Commerciale();

		comm.setNomeRef(nomeRef);
		comm.setCognomeRef(cognomeRef);
		comm.setRagioneSociale(ragioneSociale);
		comm.setTelefono(telefono);

		indirizzoService.save(ind);
		comm.setIndirizzo(ind);

		commercialeService.insertCommerciale(comm);

		// TODO cambia reindirizzamento
		return "login";
	}

}
