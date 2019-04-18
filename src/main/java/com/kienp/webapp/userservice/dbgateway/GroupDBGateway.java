package com.kienp.webapp.userservice.dbgateway;

import java.util.List;

import com.kienp.webapp.userservice.dto.entity.Group;

public interface GroupDBGateway {

	public List<Group> getGroupListByIds(List<Integer> listId);

	public List<Group> getAllGroup();
	
	public Group getGroupById(Integer id);
	
	public void deleteGroupById(Integer id);
	
	public Group save(Group group);
}
