package com.kienp.webapp.application.presenter.user;

import java.util.List;

import com.kienp.webapp.application.model.datatable.PaginationCriteria;
import com.kienp.webapp.application.model.datatable.TablePage;
import com.kienp.webapp.application.model.user.UserDataTable;
import com.kienp.webapp.userservice.entity.Category;
import com.kienp.webapp.userservice.entity.User;

public interface UserListPresenter {
	
	public List<UserDataTable> getUserDataTable(List<User> users, List<Category> userCategoryList);
		
	public TablePage buildTablePage(List<Category> userCategoryList, List<User> userList, List<User> filteredUserList, PaginationCriteria criteria);
	
	
}
