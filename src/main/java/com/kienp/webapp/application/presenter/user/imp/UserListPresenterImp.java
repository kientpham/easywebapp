package com.kienp.webapp.application.presenter.user.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.kienp.webapp.application.model.datatable.PaginationCriteria;
import com.kienp.webapp.application.model.datatable.TablePage;
import com.kienp.webapp.application.model.user.UserDataTable;
import com.kienp.webapp.application.presenter.DataTablePresenter;
import com.kienp.webapp.application.presenter.user.UserListPresenter;
import com.kienp.webapp.userservice.entity.Category;
import com.kienp.webapp.userservice.entity.User;

@Component
public class UserListPresenterImp implements UserListPresenter {

	@Override
	public List<UserDataTable> getUserDataTable(List<User> users, List<Category> userCategoryList) {

		List<UserDataTable> returnList = new ArrayList<UserDataTable>();
		for (User user : users) {
			returnList.add(this.buildUserDataTable(user, userCategoryList));
		}
		return returnList;
	}		

	@Override
	public TablePage buildTablePage(List<Category> userCategoryList, List<User> userList, List<User> userFilteredList,
			PaginationCriteria criteria) {
		List<UserDataTable> listUser = getListUserDataTable(userFilteredList, userCategoryList);

		return DataTablePresenter.buildTablePage(listUser, criteria.getDraw(), userList.size());
	}
	
	private UserDataTable buildUserDataTable(User user, List<Category> categoryList) {
		UserDataTable userData = new UserDataTable();
		userData.setId(user.getId());
		userData.setUserName(user.getUserName());
		userData.setFullName(user.getFirstName() + " " + user.getLastName());
		userData.setEmail(user.getEmail());
		userData.setAddress(user.getAddress());
		for (Category cat : categoryList) {
			if (cat.getId() == user.getUserType()) {
				userData.setType(cat.getValue());
				continue;
			}
			if (cat.getId() == user.getStatus()) {
				userData.setStatus(cat.getValue());
			}
		}
		return userData;
	}

	private List<UserDataTable> getListUserDataTable(List<User> userList, List<Category> categoryList) {
		List<UserDataTable> list = new ArrayList<UserDataTable>();
		for (User user : userList) {
			list.add(this.buildUserDataTable(user, categoryList));
		}
		return list;
	}


}
