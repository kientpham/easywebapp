package com.kienp.webapp.application.connector.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kienp.webapp.application.model.user.GroupEdit;
import com.kienp.webapp.userservice.dto.entity.Group;
import com.kienp.webapp.userservice.service.GroupService;

@Component
public class GroupEditConnector {

	@Autowired
	private GroupService groupService;
	
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
		return group;
	}

}
