package it.beije.pascal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.pascal.service.OrderItemService;

@Controller
public class OrderItemController {
	
	@Autowired
	private OrderItemService orderItemService;
	
	@RequestMapping(value = "/orderItems", method = RequestMethod.GET)
	public String showProducts(Model model) {

		model.addAttribute("orderItems", orderItemService.getOrderItems());

		return "listOrderItems";
	}
}