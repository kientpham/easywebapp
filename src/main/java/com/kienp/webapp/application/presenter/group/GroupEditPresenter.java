package com.kienp.webapp.application.presenter.group;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kienp.webapp.application.model.group.GroupEdit;
import com.kienp.webapp.application.model.permission.PermissionJoinGroupList;
import com.kienp.webapp.userservice.dto.entity.Group;
import com.kienp.webapp.userservice.dto.entity.Permission;
import com.kienp.webapp.userservice.service.GroupService;
import com.kienp.webapp.userservice.service.PermissionService;

@Component
public class GroupEditPresenter {

	@Autowired
	private GroupService groupService;
	
	@Autowired
	private PermissionService permissionService;
	
	public GroupEdit getGroupEdit(Integer id) {
		return new GroupEdit(groupService.getGroupById(id));
	}
	
	public String saveGroup(GroupEdit groupEdit) {
		Group group=groupService.saveGroup(this.getGroupEntity(groupEdit));
		return String.format("Save %s successfully!",group.getName());
	}

	private Group getGroupEntity(GroupEdit groupEdit) {
		Group group=new Group();
		group.setId(groupEdit.getId());
		group.setName(groupEdit.getGroupName());
		group.setStatus(groupEdit.getGroupStatus());
		group.setDescription(groupEdit.getDescription());
		group.setPermissions(permissionService.getPermissionListByIds(groupEdit.getTblPermissionGroup()));
		return group;
	}

	public List<PermissionJoinGroupList> getPermissionListJoinGroup(Integer groupId) {
		List<PermissionJoinGroupList> returnList=new ArrayList<PermissionJoinGroupList>();		
		for (Permission permission: permissionService.getAllPermissions()) {
			PermissionJoinGroupList permissionJoinGroup=new PermissionJoinGroupList();
			permissionJoinGroup.setPermisisonId(permission.getId());
			permissionJoinGroup.setPermisisonName(permission.getName());
			List<Permission> groupPermissionAll= groupService.getGroupById(groupId).getPermissions();
			if (groupPermissionAll!=null) {
				for (Permission groupPermission:groupPermissionAll) {
					if (permission.getId()==groupPermission.getId()) {
						permissionJoinGroup.setIsChecked("checked");
						break;
					}
				}
			}
			returnList.add(permissionJoinGroup);
		}		
		return returnList;
	}
}
