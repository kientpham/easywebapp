package com.kienp.webapp.userservice.dbgateway.repository;

import org.springframework.data.repository.CrudRepository;

import com.kienp.webapp.userservice.dto.entity.Permission;

public interface PermissionRepository extends CrudRepository<Permission,Integer>{

}
