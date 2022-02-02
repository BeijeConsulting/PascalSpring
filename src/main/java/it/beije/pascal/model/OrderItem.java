package it.beije.pascal.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the order_item database table.
 * 
 */
@Entity
@Table(name="order_item")
@NamedQuery(name="OrderItem.findAll", query="SELECT o FROM OrderItem o")
public class OrderItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Integer quantity;

	@Column(name="sell_price")
	private Double sellPrice;

	//bi-directional many-to-one association to Order
	@ManyToOne(fetch=FetchType.LAZY)
	private Order order;

	//bi-directional many-to-one association to Product
	@ManyToOne(fetch=FetchType.LAZY)
	private Product product;

	public OrderItem() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getSellPrice() {
		return this.sellPrice;
	}

	public void setSellPrice(Double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}