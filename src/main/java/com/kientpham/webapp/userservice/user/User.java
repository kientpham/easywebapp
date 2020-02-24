package com.kientpham.webapp.userservice.user;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.kientpham.webapp.userservice.group.Group;

import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import java.util.List;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "\"USER\"")
@Getter
@Setter
public class User{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private Integer id;
	@Column(name = "USER_NAME")
	private String username;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "USER_TYPE")
	private Integer userType;
	@Column(name = "STATUS")
	private Integer status;
	@Column(name = "ADDRESS")
	private String address;
	@ManyToMany
	@JoinTable(name = "USER_GROUP_JOIN", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
		@JoinColumn(name = "GROUP_ID") })
	private List<Group> groups;
	public User() {
		//default constructor
	}
}