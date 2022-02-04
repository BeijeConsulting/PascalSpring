//package it.beije.pascal.controller;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import it.beije.pascal.model.Contatto;
//import it.beije.pascal.service.RubricaService;
//
//
//@Controller
//public class HelloController {
//	
//	@Autowired
//	private RubricaService rubricaService;
//
//	
//	@RequestMapping(value = "/hello", method = RequestMethod.GET)
//	public String hello() {
//		System.out.println("GET hello");
//		
//		List<Contatto> contatti = rubricaService.getList();
//		System.out.println("contatti : " + contatti.size());
//
//		return "hello"; // /WEB-INF/views/hello.jsp
//	}
//
//	//@RequestMapping(value = "/", method = RequestMethod.GET)
//	@GetMapping(value = "/")
//	public String index(Model model) {
//		
//		model.addAttribute("name", "Pascal");
//		
//		return "index"; // /WEB-INF/views/index.jsp
//	}
//	
//	@RequestMapping(value = "/hello", method = RequestMethod.POST)
//	public String hello(Model model, @RequestParam String fname, @RequestParam(required = false) String lname) {
//		System.out.println("POST hello");
//		System.out.println("fname : " + fname);
//		System.out.println("lname : " + lname);
//		
//		//String fname = request.getParameter("fname");
//		//String lname = request.getParameter("lname");
//		
//		model.addAttribute("fname", fname);
//		model.addAttribute("lname", lname);
//		
//		return "hello";
//	}
//
//
//}
