package com.kienp.webapp.userservice.dbgateway.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kienp.webapp.userservice.dbgateway.PermissionDBGateway;
import com.kienp.webapp.userservice.dbgateway.repository.PermissionRepository;
import com.kienp.webapp.userservice.dto.entity.Permission;

@Component
public class PermissionDBGatewayImp implements PermissionDBGateway {

	@Autowired
	private PermissionRepository permissionRepo;
	
	@Override
	public List<Permission> listAll() {
		return (List<Permission>)permissionRepo.findAll();
	}

	@Override
	public Permission findById(Integer id) {
		return permissionRepo.findById(id).orElse(new Permission());
	}

	@Override
	public void deleteById(Integer id) {		
		permissionRepo.deleteById(id);		
	}

	@Override
	public Permission save(Permission permission) {
		return permissionRepo.save(permission);
	}

	@Override
	public List<Permission> findByListIds(List<Integer> ids) {

		return (List<Permission>)permissionRepo.findAllById(ids);
	}

}
