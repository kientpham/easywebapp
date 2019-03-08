package com.kienp.webapp.userservice.dbgateway.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.kienp.webapp.userservice.dto.entity.User;

public interface UserPagingRepository extends Repository<User, Integer>{

	Page<User> findAll(Pageable pageRequest);
	
	
	@Query("SELECT u FROM User u WHERE " +
            "LOWER(u.userName) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
            "LOWER(u.firstName) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
            "LOWER(u.lastName) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +            
            "LOWER(u.email) LIKE LOWER(CONCAT('%',:searchTerm, '%'))")
	Page<User> searchUser(@Param("searchTerm") String searchTerm, Pageable pageRequest);
}
