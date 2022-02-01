package it.beije.pascal.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.pascal.model.Contatto;
import it.beije.pascal.service.RubricaDbService;
import it.beije.pascal.service.RubricaService;


@Controller
public class RubricaController {
	
	public static final String CSV_PATH= "C:\\Users\\porti\\git\\PascalSpring\\rubrica.csv";
	public static final String XML_PATH= "C:\\Users\\porti\\git\\PascalSpring\\rubrica.xml";
	

	public RubricaController() {
		System.out.println("creo RubricaController");
	}

	@Autowired
	private RubricaService rubricaService;

	@Autowired
	private RubricaDbService rubricaDbService;

	@RequestMapping(value = "/rubricaOld", method = RequestMethod.GET)
	public String lista(Model model) {
		System.out.println("GET rubrica");

		//carica rubrica da DB, CSV, XML...
		//RubricaService.getList()
		//RubricaService rubricaService = new RubricaService();

		List<Contatto> contatti = rubricaService.getList();
		System.out.println("contatti : " + contatti.size());

		//model.addAttribute("contatto", c);

		return "lista"; // /WEB-INF/views/hello.jsp
	}

	@RequestMapping(value = "/rubrica", method = RequestMethod.GET)
	public String listCSV(Model model,  @RequestParam String tipo, @RequestParam String dato){
		System.out.println("rubrica da " + tipo);

		List<Contatto> contattoList = null;

		try {
			switch(tipo) {
			case "CSV":
				contattoList = rubricaService.getCSV(CSV_PATH);break;
			case "XML":
				contattoList = rubricaService.getXML(XML_PATH);break;
			default:
				return "index";
			}
			switch(dato) {
			case "email": contattoList= rubricaService.extractContattiWithEmail(contattoList); break;
			case "tel":contattoList= rubricaService.extractContattiWithTelefono(contattoList); break;
			default: return "index";
			}
		} catch (FileNotFoundException e) {
			System.out.println("file non trovato");
		}

		model.addAttribute("listaContatti", contattoList);

		return "lista";
	}


	@RequestMapping(value="/rubricaDB", method =RequestMethod.GET)
	public String rubricaDB(Model model) {

		List<Contatto> cList = null;

		cList = rubricaDbService.listAllOrderedBy("nome", false);

		model.addAttribute("listaContatti", cList);
		return "lista";
	}

	@RequestMapping(value="/rubricaXML", method =RequestMethod.GET)
	public String rubricaXML(Model model) {

		List<Contatto> cList = null;

		try {
			cList = rubricaService.getXML(XML_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("listaContatti", cList);
		return "lista";
	}


	@RequestMapping(value="/rubricaCSV", method =RequestMethod.GET)
	public String rubricaCSV(Model model) {

		List<Contatto> cList = null;

		try {
			cList = rubricaService.getCSV(CSV_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("listaContatti", cList);
		return "lista";
	}

	@RequestMapping(value = "/rubricaEmailCSV", method = RequestMethod.GET)
	public String rubricaEmailCSV(Model model) {
		List<Contatto> cList = null;

		try {
			cList = rubricaService.getCSV(CSV_PATH);
			cList = rubricaService.extractContattiWithEmail(cList);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("listaContatti", cList);

		return "lista";
	}
	
	@RequestMapping(value = "/rubricaEmailXML", method = RequestMethod.GET)
	public String rubricaEmailXML(Model model ) {
		List<Contatto> cList = null;

		try {
			cList = rubricaService.getXML(XML_PATH);
			cList = rubricaService.extractContattiWithEmail(cList);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("listaContatti", cList);

		return "lista";
	}


	@RequestMapping(value = "/rubricaTelefonoCSV", method = RequestMethod.GET)
	public String rubricaTelefonoCSV(Model model  ) {
		List<Contatto> cList = null;

		try {
			cList = rubricaService.getCSV(CSV_PATH);
			cList = rubricaService.extractContattiWithTelefono(cList);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("listaContatti", cList);

		return "lista";
	}
	
	@RequestMapping(value = "/rubricaTelefonoXML", method = RequestMethod.GET)
	public String rubricaTelefonoXML(Model model  ) {
		List<Contatto> cList = null;

		try {
			cList = rubricaService.getXML(XML_PATH);
			cList = rubricaService.extractContattiWithTelefono(cList);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("listaContatti", cList);

		return "lista";
	}

	

}
