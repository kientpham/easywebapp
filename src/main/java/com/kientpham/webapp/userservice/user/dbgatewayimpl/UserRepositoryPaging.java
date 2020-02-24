package com.kientpham.webapp.userservice.user.dbgatewayimpl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.kientpham.webapp.userservice.user.User;
import java.util.UUID;


public interface UserRepositoryPaging extends Repository<User, UUID> {

	Page<User> findAll(Pageable pageRequest);
	@Query("SELECT u FROM User u WHERE LOWER(u.id) LIKE LOWER(CONCAT('%',:searchTerm, '%'))  OR LOWER(u.username) LIKE LOWER(CONCAT('%',:searchTerm, '%'))  OR LOWER(u.password) LIKE LOWER(CONCAT('%',:searchTerm, '%'))  OR LOWER(u.firstName) LIKE LOWER(CONCAT('%',:searchTerm, '%'))  OR LOWER(u.lastName) LIKE LOWER(CONCAT('%',:searchTerm, '%'))  OR LOWER(u.birthDate) LIKE LOWER(CONCAT('%',:searchTerm, '%'))  OR LOWER(u.email) LIKE LOWER(CONCAT('%',:searchTerm, '%'))  OR LOWER(u.userType) LIKE LOWER(CONCAT('%',:searchTerm, '%'))  OR LOWER(u.status) LIKE LOWER(CONCAT('%',:searchTerm, '%'))  OR LOWER(u.address) LIKE LOWER(CONCAT('%',:searchTerm, '%'))  OR LOWER(u.lastUpdated) LIKE LOWER(CONCAT('%',:searchTerm, '%'))  OR LOWER(u.created) LIKE LOWER(CONCAT('%',:searchTerm, '%')) ")
	Page<User> searchUser(@Param("searchTerm") String searchTerm, Pageable pageRequest);
}