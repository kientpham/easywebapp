package com.kienp.webapp.userservice.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSearch implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//private Integer id;

	private String name;

	private Integer userStatusSearch;	
}
