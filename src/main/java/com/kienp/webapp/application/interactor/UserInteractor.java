package com.kienp.webapp.application.interactor;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kienp.webapp.application.model.GroupListJoinUser;
import com.kienp.webapp.application.model.PaginationCriteria;
import com.kienp.webapp.application.model.TablePage;
import com.kienp.webapp.application.model.UserDataTable;
import com.kienp.webapp.userservice.model.UserEdit;
import com.kienp.webapp.userservice.model.UserSearch;

@Component
public interface UserInteractor {

	public UserEdit getUserForEdit(Integer id); 
	
	public List<UserDataTable> getUserList(UserSearch user);
	
	public String saveUser(UserEdit user);
	
	public String deleteUsers(List<Integer> ids);
		
	public List<GroupListJoinUser> getGroupListJoinUser(Integer userId);
	
	public TablePage getUsersListAjax(PaginationCriteria paginationCriteria); 
}
