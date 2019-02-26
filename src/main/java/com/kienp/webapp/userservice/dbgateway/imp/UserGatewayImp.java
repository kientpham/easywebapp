package com.kienp.webapp.userservice.dbgateway.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kienp.webapp.userservice.dbgateway.UserGatewayService;
import com.kienp.webapp.userservice.dbgateway.repository.UserRepository;
import com.kienp.webapp.userservice.entity.User;

@Component
public class UserGatewayImp implements UserGatewayService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> findAll() {	
		return (List<User>)userRepository.findAll();
	}

	@Override
	public User findById(Integer userId) {
		return userRepository.findById(userId).orElse(new User());
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
	public User save(User user) {		
		return userRepository.save(user);
	}

}
