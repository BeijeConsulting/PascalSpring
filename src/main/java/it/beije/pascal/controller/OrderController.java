package it.beije.pascal.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.pascal.model.Order;
import it.beije.pascal.repository.OrderRepository;
import it.beije.pascal.service.OrderService;

@Controller
public class OrderController {
/*

	@Autowired
	public OrderRepository orderRepository;

	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public String orders() {
		System.out.println("GET orders");
		
		List<Order> orders = orderRepository.findAll();
		System.out.println("orders : " + orders.size());
		System.out.println("order : " + orders.get(0));
		System.out.println("order items : " + orders.get(0));

		return "hello";
	}*/

}
