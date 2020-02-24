package com.kientpham.webapp.userservice.permission;
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
@Table(name = "PERMISSION")
@Getter
@Setter
public class Permission{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "PERMISSION_ID")
	private Integer id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "TOGGLE")
	private Boolean toggle;
	@Column(name = "MENUPATH")
	private String menuPath;
	@Column(name = "URL")
	private String url;
	@Column(name = "ICON")
	private String icon;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "TYPE")
	private Integer type;
	@ManyToMany
	@JoinTable(name = "GROUP_PERMISSION_JOIN", joinColumns = { @JoinColumn(name = "PERMISSION_ID") }, inverseJoinColumns = {
		@JoinColumn(name = "GROUP_ID") })
	private List<Group> groups;
	public Permission() {
		//default constructor
	}
}