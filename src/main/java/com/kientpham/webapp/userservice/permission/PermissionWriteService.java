package com.kientpham.webapp.userservice.permission;
import java.util.List;
import com.kientpham.webapp.userservice.permission.Permission;
import com.kientpham.webapp.commonlib.userserviceclient.dto.PermissionEditDTO;


public interface PermissionWriteService{

	public void deletePermissionById(Integer id);


	public void deleteListPermission(List<Integer> ids);

	public PermissionEditDTO savePermission(PermissionEditDTO permissionEditDTO);

}