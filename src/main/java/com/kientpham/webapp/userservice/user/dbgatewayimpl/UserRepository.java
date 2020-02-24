package com.kientpham.webapp.userservice.user.dbgatewayimpl;
import org.springframework.data.repository.CrudRepository;
import com.kientpham.webapp.userservice.user.User;



public interface UserRepository extends CrudRepository<User, Integer> {

}