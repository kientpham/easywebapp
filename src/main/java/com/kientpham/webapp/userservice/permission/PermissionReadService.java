package com.kientpham.webapp.userservice.permission;
import com.kientpham.webapp.commonlib.userserviceclient.dto.GroupJoinListDTO;
import java.util.List;
import com.kientpham.webapp.userservice.permission.Permission;
import com.kientpham.webapp.commonlib.userserviceclient.dto.PermissionTableDTO;
import com.kientpham.webapp.commonlib.userserviceclient.dto.PermissionEditDTO;


public interface PermissionReadService{

	public List<GroupJoinListDTO> getGroupJoinListDTO(String permissionId);

	public PermissionEditDTO getPermissionEditDTOById(String id);

	public List<PermissionTableDTO> getListPermissionTableDTO();

}