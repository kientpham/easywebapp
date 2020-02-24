package com.kientpham.webapp.orderservice.order;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.kientpham.webapp.userservice.user.User;

import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import java.util.List;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "\"ORDER\"")
@Getter
@Setter
public class Order{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ORDER_ID")
	private Integer id;
	@Column(name = "ORDER_TITLE")
	private String title;
	@Column(name = "STATUS")
	private Integer status;
	@Column(name = "USER_ID")
	private Integer userId;
	@ManyToOne
	@JoinTable(name = "USER_ORDER_JOIN", joinColumns = { @JoinColumn(name = "ORDER_ID") }, inverseJoinColumns = {
		@JoinColumn(name = "USER_ID") })
	private User user;
	public Order() {
		//default constructor
	}
}