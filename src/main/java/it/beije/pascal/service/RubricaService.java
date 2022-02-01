package it.beije.pascal.service;

import java.io.BufferedReader;
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

	public  List<Contatto> getCSV(){
		//parameters for the richt file
		String path = "./rubrica.csv";
		String sep = ";";

		List<Contatto> rows = new ArrayList<Contatto>();

		FileReader reader = null;
		BufferedReader bufferedReader = null;

		try {
			reader = new FileReader(path);
			bufferedReader = new BufferedReader(reader);

			String row;
			Contatto contatto;
			String[] r;
			while (bufferedReader.ready()) {
				row = bufferedReader.readLine();

				r = row.split(sep);
				contatto = new Contatto();
				contatto.setCognome(r[0]);
				contatto.setNome(r[1]);
				contatto.setTelefono(r[2]);
				contatto.setEmail(r[3]);

				System.out.println(contatto);
				rows.add(contatto);
			}

		} catch (IOException ioEx) {
			System.err.println("Errore nella lettura del file");
			ioEx.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
				if (reader != null) {
					reader.close();
				}
			} catch (Exception fEx) {
				fEx.printStackTrace();
			}
		}

		return rows;
	}

}
