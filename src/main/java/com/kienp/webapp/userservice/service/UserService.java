package com.kienp.webapp.userservice.service;

import java.util.List;

import com.kienp.webapp.userservice.entity.User;

public interface UserService {

	public List<User> getAllUsers();
	
	public User getUserById(Integer userId);
	
	public List<User> deleteListUser(List<Integer> ids);
	
	public User deleteUserById(Integer userId);
	
	public User saveUser(User user);
	
	public List<User> searchUser();
	
}
