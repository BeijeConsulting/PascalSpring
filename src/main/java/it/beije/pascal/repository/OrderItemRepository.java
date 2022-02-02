package it.beije.pascal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.pascal.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>{

}
