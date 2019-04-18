package com.kienp.webapp.userservice.dbgateway;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kienp.webapp.userservice.dto.entity.User;
import com.kienp.webapp.userservice.dto.input.PagingInputDTO;
import com.kienp.webapp.userservice.dto.output.PagingOutputDTO;

public interface UserDBGateway {

	public List<User> findAll();
	
	public User findById(Integer userId);

	public List<User> deleteListUser(List<Integer> ids);

	public void deleteUserById(Integer userId);

	public User save(User user);
	
	public Page<User> findAll(Pageable pageRequest);
	
	public PagingOutputDTO<User> searchUser(PagingInputDTO pagingInput);
	
	
}
