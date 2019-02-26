package com.kienp.webapp.application.interactor.user;

import java.util.List;

import com.kienp.webapp.application.model.datatable.PaginationCriteria;
import com.kienp.webapp.application.model.datatable.TablePage;
import com.kienp.webapp.application.model.user.UserDataTable;
import com.kienp.webapp.application.model.user.UserSearch;

public interface UserListInteractor {
	
	public List<UserDataTable> getUserList(UserSearch user);
	
	public String deleteUsers(List<Integer> ids);
	
	public TablePage getUsersListAjax(PaginationCriteria paginationCriteria); 
}
