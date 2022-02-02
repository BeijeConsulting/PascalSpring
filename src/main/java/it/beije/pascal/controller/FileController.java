package it.beije.pascal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.pascal.model.Contatto;
import it.beije.pascal.service.FileService;

@Controller
public class FileController {

	@Autowired
	private FileService fileService;

	@RequestMapping(value = "/csv", method = RequestMethod.GET)
	public String getContactList(Model model) {
		List<Contatto> contatti = fileService.readCSV();	
		for(Contatto contatto:contatti) {
			System.out.println(contatto);
		}
		model.addAttribute("contatti", contatti);
		return "file";
	}
	
	
}
