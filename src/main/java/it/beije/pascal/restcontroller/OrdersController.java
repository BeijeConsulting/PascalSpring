package it.beije.pascal.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.beije.pascal.model.Order;
import it.beije.pascal.repository.OrderRepository;
import it.beije.pascal.service.OrderService;

@RestController
public class OrdersController {
	
	@Autowired
	public OrderService orderService;

	@Autowired
	public OrderRepository orderRepository;
	
	@GetMapping(value="/orders")
	public List<Order> getOrders(){
		System.out.println("GET orders");
		
		List<Order> ordini = orderService.getOrders();
		
		return ordini;
	}
	
	@GetMapping(value="/order/{userId}")
	public Order getDetailOrder(@PathVariable Integer userId){
		System.out.println("GET order");
		
		List<Order> o = orderRepository.findByUserId(userId);
		
		return o.isEmpty() ? null : o.get(0);
	}
	
	
}
