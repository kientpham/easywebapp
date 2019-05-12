package com.kienp.webapp.application.presenter.permission;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kienp.webapp.application.model.group.GroupJoinOtherList;
import com.kienp.webapp.application.model.permission.PermissionEdit;
import com.kienp.webapp.userservice.dto.entity.Group;
import com.kienp.webapp.userservice.dto.entity.Permission;
import com.kienp.webapp.userservice.service.GroupService;
import com.kienp.webapp.userservice.service.PermissionService;

@Component
public class PermissionEditPresenter {

	@Autowired
	private PermissionService permissionService;
	
	@Autowired
	private GroupService groupService;
	
	public PermissionEdit getPermissionEdit(Integer id) {
		return new PermissionEdit(permissionService.getPermissionById(id));
	}
	
	public String savePermission(PermissionEdit permissionEdit) {
		Permission permission=permissionService.savePermision(this.getPermissionEntity(permissionEdit));
		return String.format("The permission %s have been saved succesfully!", permission.getName());
	}
	
	public List<GroupJoinOtherList> getGroupJoinPermissionList(Integer permissionId) {
		List<GroupJoinOtherList> returnList=new ArrayList<GroupJoinOtherList>();		
		for (Group group: groupService.getAllGroup()) {
			GroupJoinOtherList groupJoinUser=new GroupJoinOtherList();
			groupJoinUser.setGroupId(group.getId());
			groupJoinUser.setGroupName(group.getName());
			List<Group>userGroupAll= permissionService.getPermissionById(permissionId).getGroups();
			if (userGroupAll!=null) {
				for (Group userGroup:userGroupAll) {
					if (group.getId()==userGroup.getId()) {
						groupJoinUser.setIsChecked("checked");
						break;
					}
				}
			}
			returnList.add(groupJoinUser);
		}		
		return returnList;
	}
	
	private Permission getPermissionEntity(PermissionEdit permissionEdit) {
		Permission permission=new Permission();
		permission.setId(permissionEdit.getId());
		permission.setName(permissionEdit.getName());
		permission.setToggle(permissionEdit.getToggle());
		permission.setDescription(permissionEdit.getDescription());
		permission.setType(permissionEdit.getPermissionType());
		permission.setMenuPath(permissionEdit.getMenuPath());
		permission.setUrl(permissionEdit.getUrl());
		permission.setIcon(permissionEdit.getIcon());
		permission.setGroups(groupService.getGroupListByIds(permissionEdit.getTblPermissionGroup()));		
		return permission;
	}
	
	
}
