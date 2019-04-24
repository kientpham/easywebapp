package com.kienp.webapp.application.model.group;

import java.util.List;

import com.kienp.webapp.userservice.dto.entity.Group;

import lombok.Getter;

@Getter
public class GroupEdit {

	private Integer id;

	private String groupName;

	private Integer groupStatus;

	private String description;
	
	private List<Integer> tblPermissionGroup;;

	public GroupEdit() {

	}

	public GroupEdit(Group group) {
		this.id = group.getId();
		this.groupName = group.getName();
		this.groupStatus = group.getStatus();
		this.description = group.getDescription();
	}
}
