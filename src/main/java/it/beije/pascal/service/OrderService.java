package it.beije.pascal.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.pascal.model.Order;
import it.beije.pascal.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> getOrders() {
		return orderRepository.findAll();
	}
	
	public void addOrder(Order newOrder) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PascalSpring");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		entityManager.persist(newOrder);
		
		transaction.commit();
		entityManager.close();
	}
}