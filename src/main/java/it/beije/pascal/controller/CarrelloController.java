package it.beije.pascal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.pascal.model.OrderItem;

@Controller
public class CarrelloController {
	
	@GetMapping(value="/carrello")
	public String carrello(@RequestParam int idProdotto, @RequestParam int quantity, @RequestParam double prezzo) {
		
		OrderItem item = new OrderItem();
		item.setProductId(idProdotto);
		item.setQuantity(quantity);
		item.setSellPrice(prezzo);
//		item.setOrder_id();
		return null;
		
	}

}
