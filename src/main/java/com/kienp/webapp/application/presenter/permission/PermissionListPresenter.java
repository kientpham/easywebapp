package com.kienp.webapp.application.presenter.permission;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kienp.webapp.application.model.permission.PermissionTable;
import com.kienp.webapp.userservice.dto.entity.Permission;
import com.kienp.webapp.userservice.service.CategoryService;
import com.kienp.webapp.userservice.service.PermissionService;

@Component
public class PermissionListPresenter {

	@Autowired
	private PermissionService permissionService;

	@Autowired
	private CategoryService categoryService;

	public List<PermissionTable> getListPermissionTable() {
		Map<Integer, String> mapCategory = categoryService.getMapAllCategory();
		List<Permission> allPermission = permissionService.getAllPermissions();
		List<PermissionTable> permissionTable = new ArrayList<PermissionTable>();
		for (Permission permission : allPermission) {
			permissionTable.add(new PermissionTable(permission, mapCategory));
		}
		return permissionTable;
	}
	
	public String deletePermissions(List<Integer> ids) {
		permissionService.deleteListPermission(ids);
		return "Permission has been deleted!";
	}

}
