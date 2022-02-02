package it.beije.pascal.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import it.beije.pascal.model.Contatto;
import it.beije.pascal.repository.RubricaRepository;

@Service
public class RubricaService {

	private static final String STANDARD_SEPARATOR = ";";

	public RubricaService() {
		System.out.println("creo RubricaService");
	}
	
	@Autowired
	private RubricaRepository rubricaRepository;

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

		return getList(null);
	}
	
	public List<Contatto> getList(String cognome) {
		
//		List<Contatto> list = new ArrayList<Contatto>();
//		Contatto c1 = new Contatto();
//		c1.setNome("Claudio");
//		c1.setCognome("Bisio");
//		c1.setEmail("claudio@bisio.com");
//
//		Contatto c2 = new Contatto();
//		c2.setNome("Paolo");
//		c2.setCognome("Rossi");
//		c2.setEmail("p@rossi.com");
//
//		Contatto c3 = new Contatto();
//		c3.setNome("Leo");
//		c3.setCognome("Bianchi");
//		c3.setEmail("b@leo.com");
//
//		list.add(c1);
//		list.add(c2);
//		list.add(c3);
		
		List<Contatto> contatti = cognome != null ? rubricaRepository.findByCognome(cognome) : rubricaRepository.findAll();

		return contatti;
	}

	public  List<Contatto> getCSV(String path) throws FileNotFoundException{
		//parameters for the richt file
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
			
			//First cycle: read order of fields
			int posCognome =-1, posNome =-1, posTel =-1, posEmail =-1, posNote =-1;
			if(bufferedReader.ready()) {
				row = bufferedReader.readLine();
				r = row.split(sep); //TODO fix array out of bounds
				for (int i = 0; i < r.length; i++) {
					if (r[i].equals("COGNOME")) posCognome = i; 
					else if (r[i].equals("NOME")) posNome = i; 
					else if (r[i].equals("TELEFONO")) posTel = i; 
					else if (r[i].equals("EMAIL")) posEmail = i; 
					else if (r[i].equals("NOTE")) posNote = i; 
				}
			}
			
			//read all occurrences
			while (bufferedReader.ready()) {
				row = bufferedReader.readLine();
				
				//for edge case : add value to split 
				if((row.charAt(row.length()-1)) == STANDARD_SEPARATOR.charAt(0))
					row = row.concat(""+STANDARD_SEPARATOR+"temp");
				
				r = row.split(sep);
				contatto = new Contatto();
				if(posCognome != -1) contatto.setCognome((r[posCognome].isEmpty())? null : r[posCognome]);
				if(posNome != -1) 	contatto.setNome(	(r[posNome].isEmpty())? null : r[posNome]		);
				if(posTel != -1) 	contatto.setTelefono((r[posTel].isEmpty())? null : r[posTel]		);
				if(posEmail != -1) 	contatto.setEmail(	(r[posEmail].isEmpty())? null : r[posEmail]		);
				if(posNote != -1) 	contatto.setNote(	(r[posNote].isEmpty())? null : r[posNote]); 
				
//				System.out.println(contatto);
				
				rows.add(contatto);
			}
			
		}catch (FileNotFoundException e) {
			System.err.println("file CSV non trovato");
			throw e;
		} catch (IOException ioEx) {
			System.err.println("Errore inaspettato nella lettura del file");
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

	public List<Contatto> getXML(String path) throws FileNotFoundException{
		List<Contatto> contattiList = new ArrayList<>();
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(path);

			Element root = document.getDocumentElement();
			System.out.println("root : " + root.getTagName());

			NodeList contattiNodes = root.getElementsByTagName("contatto");

			for (int i = 0; i < contattiNodes.getLength(); i++) {
				Node contatto = contattiNodes.item(i);
				if (contatto instanceof Element) {
					Contatto c = new Contatto();
					c.setNome(extractCampoFromNode(contatto, "nome"));
					c.setCognome(extractCampoFromNode(contatto, "cognome"));
					c.setEmail(extractCampoFromNode(contatto, "email"));
					c.setTelefono(extractCampoFromNode(contatto, "telefono"));
					c.setNote(extractCampoFromNode(contatto, "note"));
					contattiList.add(c);
				}
			}

		} catch (FileNotFoundException e) {
			throw e;
		}catch (DOMException | ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		return contattiList;
	}
	
	private String extractCampoFromNode(Node contatto, String name) throws DOMException {
		Node campoNode;
		try {
			campoNode = ((Element) contatto).getElementsByTagName(name).item(0);
			String result = campoNode.getFirstChild().getNodeValue();
			return result.isEmpty() ? null : result;
		} catch (NullPointerException e) {
			return null;
		}
	}

	public List<Contatto> extractContattiWithEmail(List<Contatto> cList) {
		cList.removeIf((Contatto c) -> c.getEmail() == null);
//		for(Contatto c : cList) {
//			if(c.getEmail()==null ||c.getEmail().equals("")) {
//				cList.remove(c);
//			}
//		}
		return cList;
	}

	public List<Contatto> extractContattiWithTelefono(List<Contatto> cList) {
		cList.removeIf((Contatto c) -> c.getTelefono() == null);

//		for(Contatto c : cList) {
//			if(c.getEmail()==null ||c.getEmail().equals("")) {
//				cList.remove(c);
//			}
//		}
		return cList;
	}
}
