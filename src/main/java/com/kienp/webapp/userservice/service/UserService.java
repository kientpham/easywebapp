package com.kienp.webapp.userservice.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kienp.webapp.userservice.dto.entity.User;

public interface UserService {

	public List<User> getAllUsers();
	
	public Page<User> getAllUser(Pageable pageRequest);
	
	public User getUserById(Integer userId);
	
	public List<User> deleteListUser(List<Integer> ids);
	
	public User deleteUserById(Integer userId);
	
	public User saveUser(User user);
	
	public List<User> searchUser();

	public Page<User> searchUser(String searchTerm, Pageable pageRequest);
	
}
