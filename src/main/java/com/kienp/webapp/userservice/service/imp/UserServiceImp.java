package com.kienp.webapp.userservice.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kienp.webapp.userservice.dbgateway.UserGatewayService;
import com.kienp.webapp.userservice.entity.User;
import com.kienp.webapp.userservice.service.UserService;

@Component
public class UserServiceImp implements UserService{

	@Autowired
	private UserGatewayService userGateway;
	
	@Override
	public List<User> getAllUsers() {	
		return userGateway.findAll();
	}

	@Override
	public User getUserById(Integer userId) {		
		return userGateway.findById(userId);
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
		// TODO Auto-generated method stub
		return userGateway.save(user);
	}

	@Override
	public List<User> searchUser() {
		// TODO Auto-generated method stub
		return null;
	}

}
