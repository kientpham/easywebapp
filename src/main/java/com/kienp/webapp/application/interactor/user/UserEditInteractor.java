package com.kienp.webapp.application.interactor.user;

import java.util.List;

import com.kienp.webapp.application.model.user.GroupListJoinUser;
import com.kienp.webapp.application.model.user.UserEdit;

public interface UserEditInteractor {
	
	public UserEdit getUserForEdit(Integer id); 
	
	public String saveUser(UserEdit user);
	
	public List<GroupListJoinUser> getGroupListJoinUser(Integer userId);
}
