package it.beije.pascal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import it.beije.pascal.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
}