package com.kienp.webapp.userservice.dbgateway;

import java.util.List;

import com.kienp.webapp.userservice.dto.entity.Permission;

public interface PermissionDBGateway {

	public List<Permission> listAll();
	
	public List<Permission> findByListIds(List<Integer> ids);
	
	public Permission findById(Integer id);
	
	public void deleteById(Integer id);
	
	public Permission save(Permission permission);
}
