package com.kienp.webapp.application.presenter;

import java.util.List;

import com.kienp.webapp.application.model.PaginationCriteria;
import com.kienp.webapp.application.model.TablePage;
import com.kienp.webapp.application.model.UserDataTable;
import com.kienp.webapp.userservice.entity.Category;
import com.kienp.webapp.userservice.entity.User;
import com.kienp.webapp.userservice.model.UserEdit;

public interface UserPresenter {
	
	public List<UserDataTable> getUserDataTable(List<User> users, List<Category> userCategoryList);
	
	public UserEdit buildUserEdit(User user);
	
	public TablePage buildTablePage(List<Category> userCategoryList, List<User> userList, List<User> filteredUserList, PaginationCriteria criteria);
	
}
