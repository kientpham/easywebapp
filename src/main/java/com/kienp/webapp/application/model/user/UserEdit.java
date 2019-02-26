package com.kienp.webapp.application.model.user;

import java.io.Serializable;
import java.util.List;

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

}
