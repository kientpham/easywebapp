package com.kienp.webapp.application.model.user;

import java.util.Map;

import com.kienp.webapp.userservice.entity.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDataTable {

	private Integer id;
	
	private String userName;
	
	private String fullName;
	
	private String email;

	private String type;
	
	private String status;
	
	private String address;
	
	public UserDataTable(User user, Map<Integer,String> categoryMap) {
		this.setId(user.getId());
		this.setUserName(user.getUserName());
		this.setFullName(user.getFirstName() + " " + user.getLastName());
		this.setEmail(user.getEmail());
		this.setAddress(user.getAddress());
		this.setType(categoryMap.get(user.getUserType()));
		this.setStatus(categoryMap.get(user.getStatus()));		
	}
	
}
