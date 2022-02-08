package it.beije.pascal.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.pascal.model.Order;
import it.beije.pascal.repository.OrderRepository;

@RestController
public class OrderRestController {

	@Autowired
	private OrderRepository orderRepository;
	
	@PostMapping(value = "viewOrders")
	public List<Order> viewOrders(){
		
		return orderRepository.findAll();
	}
	
	@GetMapping(value="getOrder")
	public Order getOrder(@RequestBody Integer id) {
		Optional<Order> opt =  orderRepository.findById(id);
		return opt.isPresent() ? opt.get() : null;
	}
	
}
