package com.kienp.webapp.userservice.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kienp.webapp.userservice.domain.PermissionDomain;
import com.kienp.webapp.userservice.dto.entity.Permission;
import com.kienp.webapp.userservice.service.PermissionService;

@Component
public class PermissionServiceImp implements PermissionService {

	@Autowired
	private PermissionDomain permissionDomain;

	@Override
	public List<Permission> getAllPermissions() {

		return permissionDomain.getAllPermissions();
	}

	@Override
	public Permission getPermissionById(Integer id) {

		return permissionDomain.getPermissionById(id);
	}

	@Override
	public void deleteListPermission(List<Integer> ids) {
		for (Integer id : ids) {
			permissionDomain.deletePermissionById(id);
		}
	}

	@Override
	public Permission savePermision(Permission permission) {
		return permissionDomain.savePermission(permission);
	}

}
