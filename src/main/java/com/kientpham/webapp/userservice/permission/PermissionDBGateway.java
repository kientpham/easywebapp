package com.kientpham.webapp.userservice.permission;
import java.util.List;
import com.kientpham.webapp.userservice.permission.Permission;

public interface PermissionDBGateway{
	public List<Permission> findAll();

	public Permission findById(Integer id);

	public List<Permission> findByListIds(List<Integer> listId);

	public void deleteById(Integer id);

	public Permission save(Permission entity);


}