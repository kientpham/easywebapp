package com.kienp.webapp.application.model.user;

import java.io.Serializable;
import java.util.List;

import com.kienp.webapp.userservice.entity.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserEdit implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;

	private String username;
	
	private String password;

	private String firstName;

	private String lastName;

	private String email;

	private Integer userType;

	private Integer userStatus;

	private String address;
	
	private List<Integer> tblUserGroup;
	
	public UserEdit(User user) {
		if (user != null) {
			this.setId(user.getId());
			this.setUsername(user.getUserName());
			this.setFirstName(user.getFirstName());
			this.setPassword(user.getPassword());
			this.setLastName(user.getLastName());
			this.setEmail(user.getEmail());
			this.setUserType(user.getUserType());
			this.setUserStatus(user.getStatus());
			this.setAddress(user.getAddress());
		}
	}

}
