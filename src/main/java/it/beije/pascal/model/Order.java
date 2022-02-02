package it.beije.pascal.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "order")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="amount")
	private Double amount;
	
	@Column(name="creation_datetime")
	private LocalDateTime dateTime;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	
	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	public String getDateTimeAsString() {
		return dateTime.format(DateTimeFormatter.ISO_DATE_TIME);
	}

	public void setDateTime(String dateTime) {
		this.dateTime = LocalDateTime.parse(dateTime, DateTimeFormatter.ISO_DATE_TIME);
	}
	
	
	public String toString() {
		StringBuilder builder = new StringBuilder("{id: ").append(id)
				.append(", userId: ").append(userId)
				.append(", amount: ").append(amount)
				.append(", dateTime: ").append(dateTime)
				.append("}");
		
		return builder.toString();
	}

}
