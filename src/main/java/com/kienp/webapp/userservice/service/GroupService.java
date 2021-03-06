package com.kienp.webapp.userservice.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kienp.webapp.userservice.dto.entity.Group;

@Component
public interface GroupService {
		
	public List<Group> getGroupListByIds(List<Integer> listId);
	
	public List<Group> getAllGroup();
	
	public Group getGroupById(Integer id);
	
	public void deleteGroupById(Integer id);
	
	public Group saveGroup(Group group);

	public void deleteListGroup(List<Integer> ids);
}
