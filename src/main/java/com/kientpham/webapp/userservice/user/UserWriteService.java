package com.kientpham.webapp.userservice.user;
import java.util.List;
import com.kientpham.webapp.userservice.user.User;
import com.kientpham.webapp.commonlib.userserviceclient.dto.UserEditDTO;
import java.util.UUID;



public interface UserWriteService{

	public void deleteUserById(UUID id);


	public void deleteListUser(List<UUID> ids);

	public UserEditDTO saveUser(UserEditDTO userEditDTO);

}