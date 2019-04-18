package com.kienp.webapp.userservice.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kienp.webapp.userservice.domain.GroupDomain;
import com.kienp.webapp.userservice.dto.entity.Group;
import com.kienp.webapp.userservice.service.GroupService;

@Component
public class GroupServiceImp implements GroupService  {

	@Autowired
	private GroupDomain groupDomain;
	
	@Override
	public List<Group> getGroupListByIds(List<Integer> listId) {
		 
		return groupDomain.getGroupListByIds(listId);
	}

	@Override
	public List<Group> getAllGroup() {
		
		return (List<Group>)groupDomain.getAllGroup();
	}

	@Override
	public Group getGroupById(Integer id) {
		return groupDomain.getGroupById(id);
	}
	
	@Override
	public void deleteListGroup(List<Integer> ids) {
		for (Integer id:ids) {
			this.deleteGroupById(id);
		}		
	}

	@Override
	public void deleteGroupById(Integer id) {
		groupDomain.deleteGroupById(id);		
	}

	@Override
	public Group saveGroup(Group group) {
		return groupDomain.saveGroup(group);
	}

}
