package it.beije.pascal.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import it.beije.pascal.model.Contatto;

@Service
public class RubricaCSVService {
	
	public List<Contatto> loadRubricaFromCSV(String pathFile, String separator) {

		List<Contatto> rows = new ArrayList<Contatto>();
		
		FileReader reader = null;
		BufferedReader bufferedReader = null;
		
		try {
			reader = new FileReader(pathFile);
			bufferedReader = new BufferedReader(reader);
			
			String row;
			Contatto contatto;
			String[] r;
			
			int posNome = -1;
			int posCognome = -1;
			int posTelefono = -1;
			int posEmail = -1;
			int posNote = -1;
			
			row = bufferedReader.readLine();
			r = row.split(separator);
			
			for (int i = 0; i < r.length; i++) {
				switch(r[i]) {
				case "COGNOME":
					posCognome = i;
					break;
				case "NOME":
					posNome = i;
					break;
				case "TELEFONO":
					posTelefono = i;
					break;
				case "EMAIL":
					posEmail = i;
					break;
				case "NOTE":
					posEmail = i;
					break;
				} 
			}
			
			while (bufferedReader.ready()) {
				row = bufferedReader.readLine();
			
				r = row.split(separator, -1);
				
				contatto = new Contatto();
				if(posNome != -1)
					if(r[posNome].isEmpty()) {
						contatto.setNome(null);
					}else {
						contatto.setNome(r[posNome]);
					}
				if(posCognome != -1)
					if(r[posCognome].isEmpty()) {
						contatto.setCognome(null);
					}else {
						contatto.setCognome(r[posCognome]);
					}
				if(posTelefono != -1)
					if(r[posTelefono].isEmpty()) {
						contatto.setTelefono(null);
					}else {
						contatto.setTelefono(r[posTelefono]);
					}
				if(posEmail != -1)
					if(r[posEmail].isEmpty()) {
						contatto.setEmail(null);
					}else {
						contatto.setEmail(r[posEmail]);
					}
				if(posNote != -1)
					if(r[posNote].isEmpty()) {
						contatto.setNote(null);
					}else {
						contatto.setNote(r[posNote]);
					}
				
				rows.add(contatto);
			}
			
		} catch (IOException ioEx) {
			System.err.println("Errore lettura file");
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
