package com.kienp.webapp.userservice.dto.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;


import lombok.Getter;
import lombok.Setter;

/**
 * The persistent class for the ACCOUNT database table.
 * 
 */
@Entity
@Table(name = "\"GROUP\"")
@Getter
@Setter
public class Group implements Serializable
{
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name = "GROUP_ID")
  private Integer id;

  @Column(name = "GROUP_NAME")
  private String name;

  @Column(name = "DESCRIPTION")
  private String description;
  
  @Column(name = "STATUS")
  private Integer status;
  /**
   * constructor
   */
  
  @ManyToMany//(mappedBy ="groups")
  @JoinTable(name = "USER_GROUP_JOIN",
	        joinColumns = {@JoinColumn(name = "GROUP_ID")},
	        inverseJoinColumns = {@JoinColumn(name = "USER_ID")}
	    )
  private List<User> users;  
  
  @ManyToMany
  @JoinTable(name="GROUP_PERMISSION_JOIN",
		  joinColumns=@JoinColumn(name="GROUP_ID"),
		  inverseJoinColumns=@JoinColumn(name="PERMISSION_ID")
		  )
  private List<Permission> permissions;
  
  public Group()
  {
    // default constructor
  }

}