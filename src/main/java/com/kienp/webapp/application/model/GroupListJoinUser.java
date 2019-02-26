package com.kienp.webapp.application.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupListJoinUser implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer groupId;

	private String groupName;

	private String isUserIn;

}
