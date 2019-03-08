package com.kienp.webapp.userservice.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.kienp.webapp.userservice.dbgateway.UserGatewayService;
import com.kienp.webapp.userservice.dto.entity.User;
import com.kienp.webapp.userservice.dto.input.PagingInputDTO;
import com.kienp.webapp.userservice.dto.output.PagingOutputDTO;

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

	public void deleteUserById(Integer userId) {
		userGateway.deleteUserById(userId);
	}

	public User saveUser(User user) {
		return userGateway.save(user);
	}
	
	public Page<User> getAllUser(Pageable pageRequest){
		return userGateway.findAll(pageRequest);
	}
	
	public PagingOutputDTO<User> searchUser(PagingInputDTO pagingInput) {
		
		return userGateway.searchUser(pagingInput);
	}
}
