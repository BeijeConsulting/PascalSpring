package it.beije.pascal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

/*
 * CREATE TABLE `order_item` (
  `id` Integer(11) NOT NULL AUTO_INCREMENT,
  `order_id` Integer(11) NOT NULL,
  `product_id` Integer(11) NOT NULL,
  `sell_price` double NOT NULL,
  `quantity` Integer(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_order_idx` (`order_id`),
  KEY `fk_product_idx` (`product_id`),
  CONSTRAINT `fk_order` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`),
  CONSTRAINT `fk_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB
 */

@Entity
@Table(name = "order_item")
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "order_id")
	private Integer orderId;
	
	@Column(name = "product_id")
	private Integer productId;
	
	@Column(name = "sell_price")
	private double sellPrice;
	
	@Column(name = "quantity")
	private Integer quantity;

	public OrderItem() {
		super();
	}

	public OrderItem(Integer id, Integer orderId, Integer productId, double sellPrice, Integer quantity) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.productId = productId;
		this.sellPrice = sellPrice;
		this.quantity = quantity;
	}

	public OrderItem(Order order, Product product, Integer quantity) {
		this.orderId = order.getId();
		this.productId = product.getId();
		this.quantity = quantity;
		this.sellPrice = product.getPrice();
		order.setAmount(order.getAmount()+ (product.getPrice() * quantity));
	}
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

	public double getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
}
