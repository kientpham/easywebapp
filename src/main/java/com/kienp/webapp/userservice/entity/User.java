package com.kienp.webapp.userservice.entity;

import java.util.ArrayList;
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
@Table(name = "\"USER\"")
@Getter
@Setter
public class User //implements Serializable
{
//  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name = "USER_ID")
  private Integer id;

  @Column(name = "USER_NAME")
  private String userName;

  @Column(name = "PASSWORD")
  private String password;
  
  @Column(name = "FIRST_NAME")
  private String firstName;
  
  @Column(name = "LAST_NAME")
  private String lastName;
  
  @Column(name = "EMAIL")
  private String email;

  @Column(name = "ADDRESS")
  private String address;

  @Column(name = "STATUS")  
  private Integer status;

  @Column(name = "USER_TYPE")
  private Integer userType;

  @ManyToMany//(mappedBy = "users",cascade = CascadeType.ALL )
  @JoinTable(
		  name="USER_GROUP_JOIN",
		  joinColumns= @JoinColumn(name="USER_ID"),
		  inverseJoinColumns= @JoinColumn(name="GROUP_ID"))
  private List<Group> groups =new ArrayList<Group>();
  /**
   * constructor
   */
  public User()
  {
    // default constructor
  }

}