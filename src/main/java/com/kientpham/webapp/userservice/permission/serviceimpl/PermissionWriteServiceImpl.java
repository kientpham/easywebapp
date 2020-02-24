package com.kientpham.webapp.userservice.permission.serviceimpl;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Map;

import com.kientpham.webapp.userservice.permission.Permission;
import com.kientpham.webapp.userservice.permission.PermissionDomain;
import com.kientpham.webapp.userservice.permission.PermissionWriteService;
import com.kientpham.webapp.commonlib.userserviceclient.dto.PermissionEditDTO;
import com.kientpham.webapp.userservice.group.Group;
import com.kientpham.webapp.userservice.group.GroupDomain;
import com.kientpham.webapp.commonlib.userserviceclient.dto.GroupJoinListDTO;
import com.kientpham.webapp.commonlib.userserviceclient.dto.PermissionTableDTO;
import com.kientpham.webapp.shareservice.lookup.LookupReadService;

@Component
public class PermissionWriteServiceImpl implements PermissionWriteService{

	@Autowired
	private PermissionDomain permissionDomain;

	@Autowired
	private LookupReadService lookupReadService;

	@Autowired
	private GroupDomain groupDomain;

	@Override
	public void deletePermissionById(Integer id) {
		permissionDomain.deleteById(id);		
	}

	@Override
	public void deleteListPermission(List<Integer> ids) {
		for (Integer id:ids) {
			permissionDomain.deleteById(id);
		}		
	}

	@Override
	public PermissionEditDTO savePermission(PermissionEditDTO permissionEditDTO) {
		Permission permission=permissionDomain.getPermissionEntity(permissionEditDTO);
		permission.setGroups(groupDomain.findByListIds(permissionEditDTO.getGroups()));
;		permissionDomain.save(permission);
		return permissionEditDTO;
	}
}