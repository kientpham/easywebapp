package com.kienp.webapp.userservice.service;

import java.util.List;

import com.kienp.webapp.userservice.dto.entity.Permission;

public interface PermissionService {
	
	public List<Permission> getAllPermissions();
	
	public Permission getPermissionById(Integer id);
	
	public void deleteListPermission(List<Integer> ids);
	
	public Permission savePermision(Permission permission);

}
