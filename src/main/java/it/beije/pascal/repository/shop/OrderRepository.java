package it.beije.pascal.repository.shop;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.pascal.model.Order;

public interface OrderRepository extends JpaRepository<Order,Integer>{

}
