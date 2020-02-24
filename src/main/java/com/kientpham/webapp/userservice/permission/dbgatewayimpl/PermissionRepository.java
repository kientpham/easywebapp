package com.kientpham.webapp.userservice.permission.dbgatewayimpl;
import org.springframework.data.repository.CrudRepository;
import com.kientpham.webapp.userservice.permission.Permission;


public interface PermissionRepository extends CrudRepository<Permission, String> {

}