package com.kientpham.webapp.orderservice.productcategory;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PRODUCT_CATEGORY")
@Getter
@Setter
public class ProductCategory{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CATEGORY_ID")
	private Integer id;
	@Column(name = "CATEGORY_NAME")
	private String name;
	@Column(name = "DESCRIPTION")
	private String description;
	public ProductCategory() {
		//default constructor
	}
}