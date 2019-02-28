package com.kienp.webapp.userservice.dbgateway.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kienp.webapp.userservice.dto.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

//	User save(User user);
	
	List<User> findTop20ByOrderByFirstNameAsc();
}
