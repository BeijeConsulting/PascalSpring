package it.beije.pascal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import it.beije.pascal.model.Contatto;


@Service
public class RubricaService {
	
	public RubricaService() {
		System.out.println("creo RubricaService");
	}
	
	public List<Contatto> getList() {
		
		List<Contatto> list = new ArrayList<Contatto>();
		Contatto c1 = new Contatto();
		c1.setNome("Claudio");
		c1.setCognome("Bisio");
		c1.setEmail("claudio@bisio.com");

		Contatto c2 = new Contatto();
		c2.setNome("Paolo");
		c2.setCognome("Rossi");
		c2.setEmail("p@rossi.com");

		Contatto c3 = new Contatto();
		c3.setNome("Leo");
		c3.setCognome("Bianchi");
		c3.setEmail("b@leo.com");

		list.add(c1);
		list.add(c2);
		list.add(c3);
		
		return list;
	}

}
