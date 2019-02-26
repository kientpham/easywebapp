package com.kienp.webapp.userservice.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kienp.webapp.userservice.dbgateway.repository.GroupRepository;
import com.kienp.webapp.userservice.entity.Group;
import com.kienp.webapp.userservice.service.GroupService;

@Component
public class GroupServiceImp implements GroupService  {

	@Autowired
	private GroupRepository groupRepository;

	@Override
	public List<Group> getGroupListByIds(List<Integer> listId) {
		 
		return groupRepository.findByIdIn(listId);
	}

	@Override
	public List<Group> getAllGroup() {
		return (List<Group>)groupRepository.findAll();
	}

}
