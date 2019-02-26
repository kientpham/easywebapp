package com.kienp.webapp.application.presenter.user;

import com.kienp.webapp.application.model.user.UserEdit;
import com.kienp.webapp.userservice.entity.User;

public interface UserEditPresenter {

	public UserEdit buildUserEdit(User user);
	
}
