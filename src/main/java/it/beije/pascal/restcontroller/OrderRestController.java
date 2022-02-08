package it.beije.pascal.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.beije.pascal.model.Order;
import it.beije.pascal.repository.OrderRepository;
import it.beije.pascal.service.OrderService;


@RestController
@RequestMapping("api")
public class OrderRestController {
	
	@Autowired
	private OrderService orderService;

	@Autowired
	public OrderRepository orderRepository;

	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public List<Order> orders() {
		System.out.println("GET orders");
		
		List<Order> orders = orderRepository.findAll();
		System.out.println("orders : " + orders.size());
		System.out.println("order : " + orders.get(0));
		System.out.println("order items : " + orders.get(0).getItems());

		return orders;
	}
	
	@PostMapping(value ="/newOrder")
	public Order insert(@RequestBody Order order) {
		return orderService.insert(order);
	}
	
}
