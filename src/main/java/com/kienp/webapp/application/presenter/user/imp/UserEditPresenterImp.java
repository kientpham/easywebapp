package com.kienp.webapp.application.presenter.user.imp;

import org.springframework.stereotype.Component;

import com.kienp.webapp.application.model.user.UserEdit;
import com.kienp.webapp.application.presenter.user.UserEditPresenter;
import com.kienp.webapp.userservice.entity.User;

@Component
public class UserEditPresenterImp implements UserEditPresenter {

	@Override
	public UserEdit buildUserEdit(User user) {
		UserEdit userEdit = new UserEdit();
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
}
