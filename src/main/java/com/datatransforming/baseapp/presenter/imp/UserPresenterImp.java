package com.datatransforming.baseapp.presenter.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.datatransforming.baseapp.common.CategoryGroupName;
import com.datatransforming.baseapp.entity.Category;
import com.datatransforming.baseapp.entity.User;
import com.datatransforming.baseapp.presenter.UserPresenter;
import com.datatransforming.baseapp.presenter.ouput.UserDataTable;
import com.datatransforming.baseapp.presenter.ouput.UserEdit;
import com.datatransforming.baseapp.repository.CategoryRepository;

@Component
public class UserPresenterImp implements UserPresenter{

	@Autowired
	private CategoryRepository categoryRepo;
	
	@Override
	public List<UserDataTable> getUserDataTable(List<User> users) {
		
		List<UserDataTable> returnList=new ArrayList<UserDataTable>();
		List<Category> userCategoryList=new ArrayList<Category>();
		userCategoryList.addAll(categoryRepo.findByCategoryGroup(CategoryGroupName.USER_TYPE));
		userCategoryList.addAll(categoryRepo.findByCategoryGroup(CategoryGroupName.USER_STATUS));		
		for(User user:users) {
			returnList.add(this.buildUserDataTable(user, userCategoryList));
		}		
		return returnList;
	}
	
	@Override
	public UserEdit buildUserEdit(User user) {
		UserEdit userEdit=new UserEdit();
		if (user != null) {
			userEdit.setId(user.getId());
			userEdit.setUsername(user.getUserName());
			userEdit.setFirstName(user.getFirstName());
			userEdit.setPassword(user.getPassword());
			userEdit.setLastName(user.getLastName());
			userEdit.setEmail(user.getEmail());
			userEdit.setUserType(user.getUserType());
			userEdit.setUserStatus(user.getStatus());
			userEdit.setAddress(user.getAddress());
		}		
		return userEdit;
	}
	
	private UserDataTable buildUserDataTable(User user, List<Category> categoryList){
		UserDataTable userData=new UserDataTable();
		userData.setId(user.getId());
		userData.setUserName(user.getUserName());
		userData.setFullName(user.getFirstName() + " " + user.getLastName());
		userData.setEmail(user.getEmail());
		userData.setAddress(user.getAddress());
		for(Category cat:categoryList) {
			if (cat.getId()== user.getUserType()) {
				userData.setType(cat.getValue());
				continue;
			}
			if(cat.getId()==user.getStatus()) {
				userData.setStatus(cat.getValue());
			}		
		}
		return userData;
	}


}
