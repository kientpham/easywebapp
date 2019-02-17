package com.datatransforming.baseapp.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.datatransforming.baseapp.presenter.input.UserSearch;
import com.datatransforming.baseapp.presenter.ouput.GroupListJoinUser;
import com.datatransforming.baseapp.presenter.ouput.UserDataTable;
import com.datatransforming.baseapp.presenter.ouput.UserEdit;

@Component
public interface UserService {

	public UserEdit getUserForEdit(Integer id); 
	
	public List<UserDataTable> getUserList(UserSearch user);
	
	public String saveUser(UserEdit user);
	
	public String deleteUsers(List<Integer> ids);
		
	public List<GroupListJoinUser> getGroupListJoinUser(Integer userId);
}
