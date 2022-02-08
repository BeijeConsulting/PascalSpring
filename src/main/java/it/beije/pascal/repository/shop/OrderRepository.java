package it.beije.pascal.repository.shop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.pascal.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer>{

}
