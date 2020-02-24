package com.kientpham.webapp.userservice.permission.serviceimpl;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Map;

import com.kientpham.webapp.userservice.permission.Permission;
import com.kientpham.webapp.userservice.permission.PermissionDomain;
import com.kientpham.webapp.userservice.permission.PermissionReadService;
import com.kientpham.webapp.commonlib.userserviceclient.dto.PermissionEditDTO;
import java.util.stream.Collectors;import com.kientpham.webapp.userservice.group.Group;
import com.kientpham.webapp.userservice.group.GroupReadService;
import com.kientpham.webapp.commonlib.userserviceclient.dto.GroupJoinListDTO;
import com.kientpham.webapp.userservice.group.GroupDomain;
import com.kientpham.webapp.commonlib.userserviceclient.dto.PermissionTableDTO;
import com.kientpham.webapp.shareservice.lookup.LookupReadService;

@Component
public class PermissionReadServiceImpl implements PermissionReadService{

	@Autowired
	private PermissionDomain permissionDomain;

	@Override
	public PermissionEditDTO getPermissionEditDTOById(String id) {
		return new PermissionEditDTO(permissionDomain.findById(id));
	}

	@Autowired
	private LookupReadService lookupReadService;

	@Override
	public List<PermissionTableDTO> getListPermissionTableDTO() {
		Map<Integer, String> lookupMap = lookupReadService.getMapAllLookup();
		List<Permission> allPermission = permissionDomain.findAll();
		List<PermissionTableDTO> permissionTable = new ArrayList<PermissionTableDTO>();
		for (Permission permission :allPermission) {
 			permissionTable.add(new PermissionTableDTO(permission, lookupMap));
		}
		return permissionTable;
	}

	@Autowired
	private GroupDomain groupDomain;

	@Override
	public List<GroupJoinListDTO> getGroupJoinListDTO(String permissionId) {
		if (!permissionId.isEmpty()) {
			return groupDomain.getGroupJoinListDTO(permissionDomain.findById(permissionId).getGroups().stream().map(Group::getId).collect(Collectors.toSet()));
		}
		return groupDomain.getGroupJoinListDTO(null);
	}

}