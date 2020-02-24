package com.kientpham.webapp.orderservice.order;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.UUID;
import java.util.Currency;import com.kientpham.webapp.orderservice.orderitem.OrderItem;

import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import java.util.List;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "\"ORDER\"")
@Getter
@Setter
public class Order{
	@Id
	@Column(name = "ORDER_ID")
	private UUID id;
	@Column(name = "ORDER_NO")
	private String number;
	@Column(name = "TOTAL_PRICE")
	private Currency totalPrice;
	@Column(name = "STATUS")
	private Integer status;
	@Column(name = "USER_ID")
	private UUID userId;
	@OneToMany
	@JoinTable(name = "null", joinColumns = { @JoinColumn(name = "ORDER_ITEM_ID") }, inverseJoinColumns = {
		@JoinColumn(name = "null") })
	private List<OrderItem> orderItems;
	public Order() {
		//default constructor
	}
}