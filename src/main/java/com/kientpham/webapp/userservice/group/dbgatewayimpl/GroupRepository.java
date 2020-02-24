package com.kientpham.webapp.userservice.group.dbgatewayimpl;
import org.springframework.data.repository.CrudRepository;
import com.kientpham.webapp.userservice.group.Group;


public interface GroupRepository extends CrudRepository<Group, Integer> {

}