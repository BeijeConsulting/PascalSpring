package it.beije.pascal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.pascal.model.Contatto;
import it.beije.pascal.service.DatabaseService;

@Controller
public class DatabaseController {
	
	@Autowired
	private DatabaseService dbs;

	@RequestMapping(value = "/database", method = RequestMethod.GET)
	public String selectAllUser(Model model) {
		System.out.println("GET database");
		
		List<Contatto> contatti = dbs.getList();
		System.out.println("contatti : " + contatti.size());
		
		model.addAttribute("contatti", contatti);
		
		return "selectDBContatti"; // /WEB-INF/views/hello.jsp
	}
	
}
