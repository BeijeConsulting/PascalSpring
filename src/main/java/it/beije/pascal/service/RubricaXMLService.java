package it.beije.pascal.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import it.beije.pascal.model.Contatto;

@Service
public class RubricaXMLService {

	public List<Contatto> loadRubricaFromXML(String pathFile) throws Exception {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		
		Document document = documentBuilder.parse(pathFile);
		
		Element root = document.getDocumentElement();
		
		NodeList childNodes = root.getChildNodes();
		
		List<Contatto> prova = new ArrayList<Contatto>();
		
		for (int i = 0; i < childNodes.getLength(); i++) {
			Contatto contatto = new Contatto();
			Node node = childNodes.item(i);
			if (node instanceof Element) {
				Element el = (Element)node;
				
				List<Element> values = getChildElements(el);
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
				
				prova.add(contatto);
				
			}
		}
		
		return prova;
			
	}
	
	private static List<Element> getChildElements(Element element) {
		List<Element> childElements = new ArrayList<Element>();
		NodeList nodeList = element.getChildNodes();
		for (int n = 0; n < nodeList.getLength(); n++) {
			if (nodeList.item(n) instanceof Element) childElements.add((Element)nodeList.item(n));
		}
		
		return childElements;
	}
	
	private static boolean controlloNuovoFile(File f) {
		boolean check = false;
		try {
			if(f.createNewFile()) {
				check = true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return check;
	}
}
