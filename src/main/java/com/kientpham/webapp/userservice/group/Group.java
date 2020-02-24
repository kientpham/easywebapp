package com.kientpham.webapp.userservice.group;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.kientpham.webapp.userservice.user.User;
import com.kientpham.webapp.userservice.permission.Permission;

import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import java.util.List;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "\"GROUP\"")
@Getter
@Setter
public class Group{
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
	@ManyToMany
	@JoinTable(name = "USER_GROUP_JOIN", joinColumns = { @JoinColumn(name = "GROUP_ID") }, inverseJoinColumns = {
		@JoinColumn(name = "USER_ID") })
	private List<User> users;
	@ManyToMany
	@JoinTable(name = "GROUP_PERMISSION_JOIN", joinColumns = { @JoinColumn(name = "GROUP_ID") }, inverseJoinColumns = {
		@JoinColumn(name = "PERMISSION_ID") })
	private List<Permission> permissions;
	public Group() {
		//default constructor
	}
}