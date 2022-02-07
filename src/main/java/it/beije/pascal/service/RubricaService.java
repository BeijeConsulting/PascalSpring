package it.beije.pascal.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import it.beije.pascal.model.Contatto;
import it.beije.pascal.repository.RubricaRepository;


@Service
public class RubricaService {
	
	public RubricaService() {
		System.out.println("creo RubricaService");
	}
	
	@Autowired
	private RubricaRepository rubricaRepository;

	public List<Contatto> getList() {
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
	
	public List<Contatto> getContattiCSV() {
		List<Contatto> contatti = null;
		
		File f= new File("C:\\javaFiles\\rubrica.csv");
		
		FileReader reader = null;
		BufferedReader bufferedReader = null;
		
		try {
			contatti = new ArrayList<Contatto>();
			reader = new FileReader(f);
			bufferedReader = new BufferedReader(reader);
			
			String row;
			Contatto contatto;
			String[] r;
			while (bufferedReader.ready()) {
				row = bufferedReader.readLine();
			
				r = row.split("\t");
				contatto = new Contatto();
				contatto.setCognome(r[0]);
				contatto.setNome(r[1]);
				contatto.setTelefono(r[2]);
				contatto.setEmail(r[3]);
				
				contatti.add(contatto);
			}
		} catch (IOException ioEx) {
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
		contatti.remove(0);
		return contatti;
	}
	
	public static List<Element> getChildElements(Element element) {
		List<Element> childElements = new ArrayList<Element>();
		NodeList nodeList = element.getChildNodes();
		for (int n = 0; n < nodeList.getLength(); n++) {
			if (nodeList.item(n) instanceof Element) childElements.add((Element)nodeList.item(n));
		}
		return childElements;
	}
	
	public List<Contatto> getContattiXML() {
		List<Contatto> contatti = null;
		
		try {
		
		contatti = new ArrayList<Contatto>();
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		
		Document document = documentBuilder.parse(new File("C:\\javaFiles\\rubrica.xml"));
		
		Element root = document.getDocumentElement(); //rubrica
		
		NodeList childNodes = root.getChildNodes(); //contatto x 2

		for (int i = 0; i < childNodes.getLength(); i++) {
			Contatto contatto = new Contatto();
			Node node = childNodes.item(i);
			if (node instanceof Element) {
				Element el = (Element)node;
				List<Element> values = getChildElements(el); //nome, cognome, email, note, telefono 
				for (Element value : values) { 
					switch (value.getTagName()) {
					case "nome":
						contatto.setNome(value.getTextContent());
						break;
					case "cognome":
						contatto.setCognome(value.getTextContent());
						break;
					case "telefono":
						contatto.setTelefono(value.getTextContent());
						break;
					case "email":
						contatto.setEmail(value.getTextContent());
						break;
					case "note":
						contatto.setNote(value.getTextContent());
					}
				}
				contatti.add(contatto);
			}
		}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return contatti;
	}
}
