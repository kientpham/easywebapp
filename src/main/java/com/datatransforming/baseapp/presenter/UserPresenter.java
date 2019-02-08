package com.datatransforming.baseapp.presenter;

import java.util.List;

import com.datatransforming.baseapp.entity.User;
import com.datatransforming.baseapp.presenter.ouput.UserDataTable;
import com.datatransforming.baseapp.presenter.ouput.UserEdit;

public interface UserPresenter {
	
	public List<UserDataTable> getUserDataTable(List<User> users);
	
	public UserEdit buildUserEdit(User user);
	
}
