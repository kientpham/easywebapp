package com.kienp.webapp.userservice.dbgateway;

import java.util.List;

import com.kienp.webapp.userservice.entity.User;

public interface UserGatewayService {

	public List<User> findAll();

	public User findById(Integer userId);

	public List<User> deleteListUser(List<Integer> ids);

	public User deleteUserById(Integer userId);

	public User save(User user);
}
