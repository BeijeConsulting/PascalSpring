package it.beije.pascal.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.pascal.model.Contatto;
import it.beije.pascal.service.CSVService;

@Controller
public class RubricaControllerCSV {
	
	@Autowired
	private CSVService CSVService;
		
	@RequestMapping(value = "/csv", method = RequestMethod.POST)
	public String csv(Model model) throws Exception {
		
		
		List<Contatto> rubrica = new ArrayList<>();
		rubrica = CSVService.readContatti("C:/temp/rubrica2.csv");
		
		model.addAttribute("rub",rubrica);

		return "db"; // /WEB-INF/views/db.jsp
	}
	

}
