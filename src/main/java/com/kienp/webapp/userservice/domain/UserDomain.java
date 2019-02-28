package com.kienp.webapp.userservice.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.kienp.webapp.userservice.dbgateway.UserGatewayService;
import com.kienp.webapp.userservice.entity.User;

@Component
public class UserDomain {

	@Autowired
	private UserGatewayService userGateway;
	
	public List<User> getAllUsers() {	
		return userGateway.findAll();
	}

	public User getUserById(Integer userId) {		
		return userGateway.findById(userId);
	}
	
	public List<User> deleteListUser(List<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	public User deleteUserById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public User saveUser(User user) {
		return userGateway.save(user);
	}
	
	public Page<User> getAllUser(Pageable pageRequest){
		return userGateway.findAll(pageRequest);
	}
}
