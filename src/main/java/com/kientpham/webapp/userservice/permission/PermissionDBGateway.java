package com.kientpham.webapp.userservice.permission;
import java.util.List;
import com.kientpham.webapp.userservice.permission.Permission;

public interface PermissionDBGateway{
	public List<Permission> findAll();

	public Permission findById(String id);

	public List<Permission> findByListIds(List<String> listId);

	public void deleteById(String id);

	public Permission save(Permission entity);


}