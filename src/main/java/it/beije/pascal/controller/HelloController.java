package it.beije.pascal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;


@Controller
public class HelloController {
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		System.out.println("GET hello");
		
		return "hello"; // /WEB-INF/views/hello.jsp
	}

	//@RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping(value = "/")
	public String index(Model model) {
		
		model.addAttribute("name", "Pascal");
		
		return "index"; // /WEB-INF/views/index.jsp
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public String hello(Model model, @RequestParam String fname, @RequestParam(required = false) String lname) {
		System.out.println("POST hello");
		System.out.println("fname : " + fname);
		System.out.println("lname : " + lname);
		
		//String fname = request.getParameter("fname");
		//String lname = request.getParameter("lname");
		
		model.addAttribute("fname", fname);
		model.addAttribute("lname", lname);
		
		return "hello";
	}

	@RequestMapping(value = "/lsit", method = RequestMethod.GET)
	public  String loadTable(Model model){
		System.out.println("GET list ");
		List<String> mesi = new ArrayList<>();
		for(Month month : java.time.Month.values()){
			mesi.add(month.toString());
		}
		model.addAttribute("mesiList", mesi);

		return "mesiList";
	}

}
