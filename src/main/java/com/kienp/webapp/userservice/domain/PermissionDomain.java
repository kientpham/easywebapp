package com.kienp.webapp.userservice.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kienp.webapp.userservice.dbgateway.PermissionDBGateway;
import com.kienp.webapp.userservice.dto.entity.Permission;

@Component
public class PermissionDomain {
	
	@Autowired
	private PermissionDBGateway permissionDBGateway;
	
	public List<Permission> getAllPermissions(){
		return permissionDBGateway.listAll();
	}
	
	public Permission getPermissionById(Integer id) {
		return permissionDBGateway.findById(id);
	}
	
	public void deletePermissionById(Integer id) {
		permissionDBGateway.deleteById(id);
	}
	
	public Permission savePermission(Permission permission) {
		return permissionDBGateway.save(permission);
	}

}
