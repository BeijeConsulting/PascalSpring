package it.beije.pascal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.pascal.model.Order_item;

@Controller
public class CarrelloController {
	
	@GetMapping(value="/carrello")
	public String carrello(@RequestParam int idProdotto, @RequestParam int quantity, @RequestParam double prezzo) {
		
		Order_item item = new Order_item();
		item.setProduct_id(idProdotto);
		item.setQuantity(quantity);
		item.setSell_price(prezzo);
//		item.setOrder_id();
		return null;
		
	}

}
