package com.kientpham.webapp.userservice.user.dbgatewayimpl;
import org.springframework.data.repository.CrudRepository;
import com.kientpham.webapp.userservice.user.User;
import java.util.UUID;



public interface UserRepository extends CrudRepository<User, UUID> {

}