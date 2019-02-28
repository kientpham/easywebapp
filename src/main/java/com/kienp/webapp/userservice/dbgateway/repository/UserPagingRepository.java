package com.kienp.webapp.userservice.dbgateway.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.kienp.webapp.userservice.entity.User;

public interface UserPagingRepository extends Repository<User, Integer>{

	Page<User> findAll(Pageable pageRequest);
}
