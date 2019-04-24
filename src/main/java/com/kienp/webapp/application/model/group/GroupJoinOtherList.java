package com.kienp.webapp.application.model.group;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupJoinOtherList implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer groupId;

	private String groupName;

	private String isChecked;

}
