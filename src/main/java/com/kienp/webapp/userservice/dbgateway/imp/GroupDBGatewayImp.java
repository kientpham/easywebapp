package com.kienp.webapp.userservice.dbgateway.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kienp.webapp.userservice.dbgateway.GroupDBGateway;
import com.kienp.webapp.userservice.dbgateway.repository.GroupRepository;
import com.kienp.webapp.userservice.dto.entity.Group;

@Component
public class GroupDBGatewayImp implements GroupDBGateway {
	@Autowired
	private GroupRepository groupRepository;

	@Override
	public List<Group> getGroupListByIds(List<Integer> listId) {

		return groupRepository.findByIdIn(listId);
	}

	@Override
	public List<Group> getAllGroup() {
		return (List<Group>) groupRepository.findAll();
	}

	@Override
	public Group getGroupById(Integer id) {
		return groupRepository.findById(id).orElse(new Group());
	}

	@Override
	public void deleteGroupById(Integer id) {
		groupRepository.deleteById(id);		
	}

	@Override
	public Group save(Group group) {
		return groupRepository.save(group);
	}

}
