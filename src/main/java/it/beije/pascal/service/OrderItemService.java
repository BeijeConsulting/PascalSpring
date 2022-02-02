package it.beije.pascal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.pascal.repository.OrderItemRepository;

@Service 
public class OrderItemService {
	@Autowired
	private OrderItemRepository orderItemRepository;
}
