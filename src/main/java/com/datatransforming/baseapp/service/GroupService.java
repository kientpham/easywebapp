package com.datatransforming.baseapp.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.datatransforming.baseapp.entity.Group;
import com.datatransforming.baseapp.presenter.ouput.GroupListJoinUser;

@Component
public interface GroupService {
	
	public List<GroupListJoinUser> getGroupListJoinUser(Integer userId);
	
	public List<Group> getGroupListByIds(List<Integer> listId);
	
}
