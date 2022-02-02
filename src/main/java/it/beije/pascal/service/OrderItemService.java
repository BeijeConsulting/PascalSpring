package it.beije.pascal.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.pascal.model.OrderItem;
import it.beije.pascal.repository.OrderItemRepository;

@Service 
public class OrderItemService {
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	public List<OrderItem> getOrderItems() {
		return orderItemRepository.findAll();
	}
	
	public void addOrderItem(OrderItem newOrderItem) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PascalSpring");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		entityManager.persist(newOrderItem);
		
		transaction.commit();
		entityManager.close();
	}
}