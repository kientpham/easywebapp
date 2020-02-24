package com.kientpham.webapp.userservice.group.serviceimpl;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Map;

import com.kientpham.webapp.userservice.group.Group;
import com.kientpham.webapp.userservice.group.GroupDomain;
import com.kientpham.webapp.userservice.group.GroupReadService;
import com.kientpham.webapp.commonlib.userserviceclient.dto.GroupEditDTO;
import java.util.stream.Collectors;import com.kientpham.webapp.userservice.user.User;
import com.kientpham.webapp.userservice.user.UserReadService;
import com.kientpham.webapp.commonlib.userserviceclient.dto.UserJoinListDTO;
import com.kientpham.webapp.userservice.user.UserDomain;
import java.util.stream.Collectors;import com.kientpham.webapp.userservice.permission.Permission;
import com.kientpham.webapp.userservice.permission.PermissionReadService;
import com.kientpham.webapp.commonlib.userserviceclient.dto.PermissionJoinListDTO;
import com.kientpham.webapp.userservice.permission.PermissionDomain;
import com.kientpham.webapp.commonlib.userserviceclient.dto.GroupTableDTO;
import com.kientpham.webapp.shareservice.lookup.LookupReadService;

@Component
public class GroupReadServiceImpl implements GroupReadService{

	@Autowired
	private GroupDomain groupDomain;

	@Override
	public GroupEditDTO getGroupEditDTOById(Integer id) {
		return new GroupEditDTO(groupDomain.findById(id));
	}

	@Autowired
	private LookupReadService lookupReadService;

	@Override
	public List<GroupTableDTO> getListGroupTableDTO() {
		Map<Integer, String> lookupMap = lookupReadService.getMapAllLookup();
		List<Group> allGroup = groupDomain.findAll();
		List<GroupTableDTO> groupTable = new ArrayList<GroupTableDTO>();
		for (Group group :allGroup) {
 			groupTable.add(new GroupTableDTO(group, lookupMap));
		}
		return groupTable;
	}

	@Autowired
	private UserDomain userDomain;

	@Override
	public List<UserJoinListDTO> getUserJoinListDTO(Integer groupId) {
		if (groupId !=null) {
			return userDomain.getUserJoinListDTO(groupDomain.findById(groupId).getUsers().stream().map(User::getId).collect(Collectors.toSet()));
		}
		return userDomain.getUserJoinListDTO(null);
	}

	@Autowired
	private PermissionDomain permissionDomain;

	@Override
	public List<PermissionJoinListDTO> getPermissionJoinListDTO(Integer groupId) {
		if (groupId !=null) {
			return permissionDomain.getPermissionJoinListDTO(groupDomain.findById(groupId).getPermissions().stream().map(Permission::getId).collect(Collectors.toSet()));
		}
		return permissionDomain.getPermissionJoinListDTO(null);
	}

}