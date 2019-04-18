package com.kienp.webapp.userservice.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kienp.webapp.userservice.dbgateway.GroupDBGateway;
import com.kienp.webapp.userservice.dto.entity.Group;

@Component
public class GroupDomain{
	
	@Autowired
	private GroupDBGateway groupDBGateway;
	
	public List<Group> getGroupListByIds(List<Integer> listId) {
		 
		return groupDBGateway.getGroupListByIds(listId);
	}
	
	public List<Group> getAllGroup() {
		return (List<Group>)groupDBGateway.getAllGroup();
	}
	
	public Group getGroupById(Integer id) {
		return groupDBGateway.getGroupById(id);
	}
	
	public void deleteGroupById(Integer id) {
		groupDBGateway.deleteGroupById(id);
	}
	
	public Group saveGroup(Group group) {
		return groupDBGateway.save(group);
	}

}
