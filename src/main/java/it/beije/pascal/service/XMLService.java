package it.beije.pascal.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Service;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



import it.beije.pascal.model.Contatto;

@Service
public class XMLService {
	
	
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
	
}
