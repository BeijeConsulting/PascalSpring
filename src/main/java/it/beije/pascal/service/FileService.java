package it.beije.pascal.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import it.beije.pascal.model.Contatto;

@Service
public class FileService {
	public List<Contatto> readCSV() {
		List<Contatto> contatti = new ArrayList<Contatto>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:/Users/ema29/javafiles/lettura.txt"));
			while (reader.ready()) {
				String row = reader.readLine();
				String columns[] = row.split(";");
				Contatto contatto = new Contatto();

				contatto.setNome(columns[0]);
				contatto.setCognome(columns[1]);
				contatto.setTelefono(columns[2]);
				contatto.setEmail(columns[3]);
				contatti.add(contatto);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return contatti;
	}
}
