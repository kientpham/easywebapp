package com.kienp.webapp.userservice.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.kienp.webapp.userservice.domain.UserDomain;
import com.kienp.webapp.userservice.dto.entity.User;
import com.kienp.webapp.userservice.service.UserService;

@Component
public class UserServiceImp implements UserService{

	@Autowired
	private UserDomain userDomain;
	
	@Override
	public List<User> getAllUsers() {	
		return userDomain.getAllUsers();
	}

	@Override
	public User getUserById(Integer userId) {		
		return userDomain.getUserById(userId);
	}

	@Override
	public List<User> deleteListUser(List<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User deleteUserById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User saveUser(User user) {

		return userDomain.saveUser(user);
	}

	@Override
	public Page<User> searchUser(String searchTerm, Pageable pageRequest) {
			
		return null;		
	}

	@Override
	public List<User> searchUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<User> getAllUser(Pageable pageRequest) {
		// TODO Auto-generated method stub
		return userDomain.getAllUser(pageRequest);
	}

}
