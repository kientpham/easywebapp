package com.kientpham.webapp.orderservice.product;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.UUID;
import java.util.Currency;import com.kientpham.webapp.orderservice.productcategory.ProductCategory;

import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import java.util.List;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
public class Product{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "PRODUCT_ID")
	private UUID id;
	@Column(name = "PRODUCT_NAME")
	private String name;
	@Column(name = "PRICE")
	private Currency price;
	@Column(name = "DESCRIPTION")
	private String description;
	@ManyToOne
	@JoinTable(name = "null", joinColumns = { @JoinColumn(name = "CATEGORY_ID") }, inverseJoinColumns = {
		@JoinColumn(name = "null") })
	private ProductCategory productCategory;
	public Product() {
		//default constructor
	}
}