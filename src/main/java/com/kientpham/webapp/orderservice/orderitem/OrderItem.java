package com.kientpham.webapp.orderservice.orderitem;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Currency;import com.kientpham.webapp.orderservice.order.Order;
import com.kientpham.webapp.orderservice.product.Product;

import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import java.util.List;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ORDER_ITEM")
@Getter
@Setter
public class OrderItem{
	@Id
	@Column(name = "ORDER_ITEM_ID")
	private String id;
	@Column(name = "QUANTITY")
	private Integer quatity;
	@Column(name = "ITEM_PRICE")
	private Currency itemPrice;
	@ManyToOne
	@JoinTable(name = "null", joinColumns = { @JoinColumn(name = "ORDER_ID") }, inverseJoinColumns = {
		@JoinColumn(name = "null") })
	private Order order;
	@ManyToOne
	@JoinTable(name = "null", joinColumns = { @JoinColumn(name = "PRODUCT_ID") }, inverseJoinColumns = {
		@JoinColumn(name = "null") })
	private Product product;
	public OrderItem() {
		//default constructor
	}
}