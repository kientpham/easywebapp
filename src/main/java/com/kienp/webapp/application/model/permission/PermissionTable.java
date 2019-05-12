package com.kienp.webapp.application.model.permission;

import java.util.Map;

import com.kienp.webapp.userservice.dto.entity.Permission;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PermissionTable {

	private Integer id;

	private String permissionName;

	private String type;

	private String toggle;

	private String menuPath;

	private String description;

	public PermissionTable(Permission permission, Map<Integer, String> categoryMap) {
		this.setId(permission.getId());
		this.setDescription(permission.getDescription());
		this.setPermissionName(permission.getName());
		this.setToggle(permission.getToggle()!=null && permission.getToggle() ? "ON" : "OFF");
		this.setMenuPath(permission.getMenuPath());
		this.setType(categoryMap.get(permission.getType()));
	}
}
