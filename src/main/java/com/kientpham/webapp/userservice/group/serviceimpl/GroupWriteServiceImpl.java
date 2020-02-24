package com.kientpham.webapp.userservice.group.serviceimpl;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Map;

import com.kientpham.webapp.userservice.group.Group;
import com.kientpham.webapp.userservice.group.GroupDomain;
import com.kientpham.webapp.userservice.group.GroupWriteService;
import com.kientpham.webapp.commonlib.userserviceclient.dto.GroupEditDTO;
import com.kientpham.webapp.userservice.user.User;
import com.kientpham.webapp.userservice.user.UserDomain;
import com.kientpham.webapp.commonlib.userserviceclient.dto.UserJoinListDTO;
import com.kientpham.webapp.userservice.permission.Permission;
import com.kientpham.webapp.userservice.permission.PermissionDomain;
import com.kientpham.webapp.commonlib.userserviceclient.dto.PermissionJoinListDTO;
import com.kientpham.webapp.commonlib.userserviceclient.dto.GroupTableDTO;
import com.kientpham.webapp.shareservice.lookup.LookupReadService;

@Component
public class GroupWriteServiceImpl implements GroupWriteService{

	@Autowired
	private GroupDomain groupDomain;

	@Autowired
	private LookupReadService lookupReadService;

	@Autowired
	private UserDomain userDomain;

	@Autowired
	private PermissionDomain permissionDomain;

	@Override
	public void deleteGroupById(Integer id) {
		groupDomain.deleteById(id);		
	}

	@Override
	public void deleteListGroup(List<Integer> ids) {
		for (Integer id:ids) {
			groupDomain.deleteById(id);
		}		
	}

	@Override
	public GroupEditDTO saveGroup(GroupEditDTO groupEditDTO) {
		Group group=groupDomain.getGroupEntity(groupEditDTO);
		group.setUsers(userDomain.findByListIds(groupEditDTO.getUsers()));
group.setPermissions(permissionDomain.findByListIds(groupEditDTO.getPermissions()));
;		groupDomain.save(group);
		return groupEditDTO;
	}
}