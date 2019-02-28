package com.kienp.webapp.userservice.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kienp.webapp.userservice.dbgateway.repository.GroupRepository;
import com.kienp.webapp.userservice.dto.entity.Group;

@Component
public class GroupDomain{

	@Autowired
	private GroupRepository groupRepository;

	
	public List<Group> getGroupListByIds(List<Integer> listId) {
		 
		return groupRepository.findByIdIn(listId);
	}
	
	public List<Group> getAllGroup() {
		return (List<Group>)groupRepository.findAll();
	}

}
