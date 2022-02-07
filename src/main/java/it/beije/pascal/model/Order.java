package it.beije.pascal.model;

import java.time.LocalDateTime;
<<<<<<< HEAD

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

// inserire apici "storti" fra il nome tabella order, perché Order è keywork riservata SQL, quindi da errore se si prova ad usarlo.
@Table(name = "order")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name = "creation_datetime")
	private LocalDateTime creation_datetime;
	@Column(name = "amount")
	private double amount;
	
	@Column(name = "user_id")
	private Integer user_id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getCreation_datetime() {
		return creation_datetime;
	}

	public void setCreation_datetime(LocalDateTime creation_datetime) {
		this.creation_datetime = creation_datetime;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	
	
	
	
}
=======
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "`order`")
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

	
	//SELECT * FROM order o JOIN order_item i ON o.id = i.order_id WHERE id = X
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)//, fetch = FetchType.LAZY
	@JoinColumn(name="order_id")
	private List<OrderItem> items;

	
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
	
	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}


	public String toString() {
		StringBuilder builder = new StringBuilder("{id: ").append(id)
				.append(", userId: ").append(userId)
				.append(", amount: ").append(amount)
				.append(", dateTime: ").append(dateTime)
				.append(", items: ").append(items.size())
				.append("}");
		
		return builder.toString();
	}

}
>>>>>>> refs/heads/main
