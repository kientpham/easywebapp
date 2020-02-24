package com.kientpham.webapp.userservice.user;
import java.util.List;
import com.kientpham.webapp.userservice.user.User;
import com.kientpham.webapp.commonlib.userserviceclient.dto.UserEditDTO;



public interface UserWriteService{

	public void deleteUserById(Integer id);


	public void deleteListUser(List<Integer> ids);

	public UserEditDTO saveUser(UserEditDTO userEditDTO);

}