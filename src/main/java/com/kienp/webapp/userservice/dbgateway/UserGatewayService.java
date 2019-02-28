package com.kienp.webapp.userservice.dbgateway;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kienp.webapp.userservice.entity.User;

public interface UserGatewayService {

	public List<User> findAll();
	
	public Page<User> findAll(Pageable pageRequest);

	public User findById(Integer userId);

	public List<User> deleteListUser(List<Integer> ids);

	public User deleteUserById(Integer userId);

	public User save(User user);
	
	
}
