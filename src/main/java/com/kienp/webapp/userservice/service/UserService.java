package com.kienp.webapp.userservice.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kienp.webapp.userservice.dto.entity.User;
import com.kienp.webapp.userservice.dto.input.PagingInputDTO;
import com.kienp.webapp.userservice.dto.output.PagingOutputDTO;

public interface UserService {

	public List<User> getAllUsers();
	
	public Page<User> getAllUser(Pageable pageRequest);
	
	public User getUserById(Integer userId);
	
	public void deleteListUser(List<Integer> ids);
	
	public void deleteUserById(Integer userId);
	
	public User saveUser(User user);
	
	public List<User> searchUser();

	public Page<User> searchUser(String searchTerm, Pageable pageRequest);
	
	public PagingOutputDTO<User> searchUser(PagingInputDTO pagingInput);
	
}
