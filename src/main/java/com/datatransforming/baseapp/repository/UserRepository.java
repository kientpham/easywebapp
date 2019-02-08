package com.datatransforming.baseapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.datatransforming.baseapp.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	User save(User user);
}
