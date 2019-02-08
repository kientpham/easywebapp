package com.datatransforming.baseapp.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="PERMISSION")
@Getter
@Setter
public class Permission {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PERMISSION_ID")
	private Integer id;
	
	@Column(name="PERMISSION_NAME")
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="TYPE")
	private Integer type;
	
	@ManyToMany(mappedBy="permissions")
	private List<Group> groups; 
	
	public Permission() {		
	}
	
}
