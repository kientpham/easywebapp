package com.kienp.webapp.application.interactor.user.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kienp.webapp.application.interactor.user.UserListInteractor;
import com.kienp.webapp.application.model.datatable.PaginationCriteria;
import com.kienp.webapp.application.model.datatable.TablePage;
import com.kienp.webapp.application.model.user.UserDataTable;
import com.kienp.webapp.application.model.user.UserSearch;
import com.kienp.webapp.application.presenter.user.UserListPresenter;
import com.kienp.webapp.common.Constants;
import com.kienp.webapp.userservice.entity.Category;
import com.kienp.webapp.userservice.entity.User;
import com.kienp.webapp.userservice.service.CategoryService;
import com.kienp.webapp.userservice.service.UserService;

@Component
public class UserListInteractorImp implements UserListInteractor{
	
	@Autowired
	private UserListPresenter userListPresenter;
		
	@Autowired
	private UserService userService;
			
	@Autowired 
	private CategoryService categoryService;		
	
	@Override
	public List<UserDataTable> getUserList(UserSearch user) {		
		if (user.getUserStatusSearch()==0 && user.getName()==Strings.EMPTY) {
			return userListPresenter.getUserDataTable(userService.getAllUsers(), this.getListUserCategory());	
		}else {
			return null; //TODO
		}		
	}	
	
	@Override
	public TablePage getUsersListAjax(PaginationCriteria paginationCriteria) {		
		List<User> userList= userService.getAllUsers();
		List<User> filteredUser= userList.stream()
				.filter(u -> u.getFirstName().contains(paginationCriteria.getSearch().getValue()))
				.collect(Collectors.toList()).subList(paginationCriteria.getStart(), paginationCriteria.getStart() + paginationCriteria.getLength());
		//List<User> filteredUser= userList.subList(paginationCriteria.getStart(), paginationCriteria.getStart() + paginationCriteria.getLength());
		return userListPresenter.buildTablePage(this.getListUserCategory() ,userList, filteredUser, paginationCriteria);		
	}	

	@Override
	public String deleteUsers(List<Integer> ids) {
		for (Integer id:ids) {
			userService.deleteUserById(id);	
		}		
		return "User has been deleted";
	}
	
	private List<Category> getListUserCategory() {
		List<String> userCatList= new ArrayList<String>();
		userCatList.add(Constants.USER_TYPE);
		userCatList.add(Constants.USER_STATUS);		
		return categoryService.getCategoryByGroups(userCatList);
	}

}
