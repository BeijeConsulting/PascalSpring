package it.beije.pascal.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * CREATE TABLE `order` (
  `id` Integer(11) NOT NULL AUTO_INCREMENT,
  `creation_datetime` datetime NOT NULL,
  `amount` double NOT NULL,
  `user_id` Integer(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_idx` (`user_id`),
  CONSTRAINT `fk_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB;
 */

@Entity
@Table(name = "order")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "creation_datetime")
	private LocalDateTime creationDateTime;
	
	@Column(name = "amount")
	private double amount;
	
	@Column(name = "user_id")
	private Integer userId;

	public Order() {
		super();
	}

	public Order(Integer id, LocalDateTime creationDateTime, double amount, Integer userId) {
		super();
		this.id = id;
		this.creationDateTime = creationDateTime;
		this.amount = amount;
		this.userId = userId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getCreationDateTime() {
		return creationDateTime;
	}

	public void setCreationDateTime(LocalDateTime creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", creationDateTime=" + creationDateTime + ", amount=" + amount + ", userId="
				+ userId + "]";
	}

	
}
