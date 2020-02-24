package com.kientpham.webapp.userservice.permission;
import com.kientpham.webapp.commonlib.userserviceclient.dto.GroupJoinListDTO;
import java.util.List;
import com.kientpham.webapp.userservice.permission.Permission;
import com.kientpham.webapp.commonlib.userserviceclient.dto.PermissionTableDTO;
import com.kientpham.webapp.commonlib.userserviceclient.dto.PermissionEditDTO;


public interface PermissionReadService{

	public List<GroupJoinListDTO> getGroupJoinListDTO(Integer permissionId);

	public PermissionEditDTO getPermissionEditDTOById(Integer id);

	public List<PermissionTableDTO> getListPermissionTableDTO();

}