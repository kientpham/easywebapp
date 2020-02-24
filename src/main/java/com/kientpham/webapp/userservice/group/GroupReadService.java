package com.kientpham.webapp.userservice.group;
import com.kientpham.webapp.commonlib.userserviceclient.dto.UserJoinListDTO;
import com.kientpham.webapp.commonlib.userserviceclient.dto.PermissionJoinListDTO;
import java.util.List;
import com.kientpham.webapp.userservice.group.Group;
import com.kientpham.webapp.commonlib.userserviceclient.dto.GroupTableDTO;
import com.kientpham.webapp.commonlib.userserviceclient.dto.GroupEditDTO;


public interface GroupReadService{

	public List<UserJoinListDTO> getUserJoinListDTO(Integer groupId);

	public List<PermissionJoinListDTO> getPermissionJoinListDTO(Integer groupId);

	public GroupEditDTO getGroupEditDTOById(Integer id);

	public List<GroupTableDTO> getListGroupTableDTO();

}