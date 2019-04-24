package com.kienp.webapp.application.model.permission;

import java.util.List;

import com.kienp.webapp.userservice.dto.entity.Permission;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PermissionEdit {

	private Integer id;

	private String name;

	private Integer permissionType;
		
	private String description;
	
	private List<Integer> tblPermissionGroup;
	
	public PermissionEdit() {
		
	}
	
	public PermissionEdit(Permission permission) {
		this.id=permission.getId();
		this.name=permission.getName();
		this.description=permission.getDescription();
		this.permissionType=permission.getType();		
	}	
}
