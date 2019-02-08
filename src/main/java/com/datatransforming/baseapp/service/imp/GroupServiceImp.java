package com.datatransforming.baseapp.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.datatransforming.baseapp.entity.Group;
import com.datatransforming.baseapp.presenter.ouput.GroupListJoinUser;
import com.datatransforming.baseapp.repository.GroupRepository;
import com.datatransforming.baseapp.service.GroupService;

@Component
public class GroupServiceImp implements GroupService  {

	@Autowired
	private GroupRepository groupRepository;
	
	@Override
	public List<GroupListJoinUser> getGroupListJoinUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Group> getGroupListByIds(List<Integer> listId) {
		 
		return groupRepository.findByIdIn(listId);
	}

}
