package com.kienp.webapp.userservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="CATEGORY")
@Getter
@Setter
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CATEGORY_ID")
	private Integer id;
	
	@Column(name="CATEGORY_GROUP")
	private String categoryGroup;
	
	@Column(name="CATEGORY_VALUE")
	private String value;
	
	@Column(name="GROUP_ORDER")
	private Integer order;
	
	@Column(name="DESCRIPTION")
	private String description;


}
