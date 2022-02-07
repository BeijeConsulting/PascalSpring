package it.beije.pascal.repository.shop;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.pascal.model.OrderItem;

public interface Order_itemRepository extends JpaRepository<OrderItem,Integer>{

}
