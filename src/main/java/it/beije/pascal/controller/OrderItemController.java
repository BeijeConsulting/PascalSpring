package it.beije.pascal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import it.beije.pascal.service.OrderItemService;

@Controller
public class OrderItemController {
	
	@Autowired
	private OrderItemService orderItemService;
}
