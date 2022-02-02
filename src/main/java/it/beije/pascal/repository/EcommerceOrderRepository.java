package it.beije.pascal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.pascal.model.Order;

public interface EcommerceOrderRepository extends JpaRepository<Order, Integer>{
	
}
