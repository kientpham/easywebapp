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
	
	private Boolean toggle;

	private Integer permissionType;
	
	private String menuPath;
	
	private String url;
	
	private String icon;
		
	private String description;
	
	private List<Integer> tblPermissionGroup;
	
	public PermissionEdit() {
		
	}
	
	public PermissionEdit(Permission permission) {
		this.id=permission.getId();
		this.name=permission.getName();
		this.toggle=permission.getToggle();
		this.description=permission.getDescription();
		this.permissionType=permission.getType();	
		this.url=permission.getUrl();
		this.menuPath=permission.getMenuPath();
		this.icon=permission.getIcon();
	}	
}
