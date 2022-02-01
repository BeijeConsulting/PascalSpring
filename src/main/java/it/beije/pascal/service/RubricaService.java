package it.beije.pascal.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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

	public List<Contatto> readCSV(String path) throws IOException {
		File file = new File(path);
		FileReader reader = null;
		List<Contatto> contatti = new ArrayList<Contatto>();
		Contatto c = new Contatto();

		reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String row;

		bufferedReader.readLine();
		while (bufferedReader.ready()) {
			row = bufferedReader.readLine();

			String[] r = row.split("\t");
			c.setCognome(r[0]);
			c.setNome(r[1]);
			c.setEmail(r[3]);
			c.setTelefono(r[2]);
//			c.setNote(r[note]);

			contatti.add(c);
		}
		bufferedReader.close();
		return contatti;
	}

}
