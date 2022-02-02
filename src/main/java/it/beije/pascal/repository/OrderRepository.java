package it.beije.pascal.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.beije.pascal.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
	
	public List<Order> findByAmountGreaterThanEqual(Double amount);
	
	public List<Order> findByDateTimeGreaterThanEqual(LocalDateTime dateTime);
	
	//@Query(nativeQuery = true, value = "SELECT * FROM Order WHERE creation_datetime >= :dateTime")
	@Query(value = "SELECT o FROM Order o WHERE dateTime >= :dateTime")
	public List<Order> searchByDateTimeGreaterThanEqual(@Param("dateTime") LocalDateTime dateTime);

}
