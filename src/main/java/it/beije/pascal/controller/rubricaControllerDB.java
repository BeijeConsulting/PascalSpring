package it.beije.pascal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import it.beije.pascal.model.Contatto;
import it.beije.pascal.service.DBConnection;

@Controller
public class rubricaControllerDB {
	
	@Autowired
	private DBConnection DBConnection;
	
	@GetMapping(value = "/")
	public String index(Model model) {
		
		return "data"; // /WEB-INF/views/db.jsp
	}
	
	@RequestMapping(value = "/data", method = RequestMethod.POST)
	public String data(Model model) throws Exception {
		
		List<Contatto> rubrica = new ArrayList<>();
		
		rubrica = DBConnection.getListJDBC();
		
		model.addAttribute("rub",rubrica);
		
		return "db";
	}
	
	

}
