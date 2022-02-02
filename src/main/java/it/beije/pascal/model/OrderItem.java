package it.beije.pascal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
	
@Entity
@Table(name = "order_item")
public class OrderItem {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@Column(name="order_id")
	private Integer orderId;
	
	@Column(name="product_id")
	private Integer productId;

	@Column(name="sell_price")
	private Double sellPrice;

	@Column(name="quantity")
	private Integer quantity;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	
	public Double getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(Double sellPrice) {
		this.sellPrice = sellPrice;
	}

	
	public String toString() {
		StringBuilder builder = new StringBuilder("{id: ").append(id)
				.append(", orderId: ").append(orderId)
				.append(", productId: ").append(productId)
				.append(", sellPrice: ").append(sellPrice)
				.append("}");
		
		return builder.toString();
	}

}
