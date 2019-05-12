package com.kienp.webapp.userservice.service.imp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.kienp.webapp.userservice.domain.UserDomain;
import com.kienp.webapp.userservice.dto.entity.Group;
import com.kienp.webapp.userservice.dto.entity.Permission;
import com.kienp.webapp.userservice.dto.entity.User;
import com.kienp.webapp.userservice.dto.input.PagingInputDTO;
import com.kienp.webapp.userservice.dto.output.PagingOutputDTO;
import com.kienp.webapp.userservice.service.UserService;

@Component
public class UserServiceImp implements UserService {

	@Autowired
	private UserDomain userDomain;

	@Override
	public List<User> getAllUsers() {
		return userDomain.getAllUsers();
	}

	@Override
	public User getUserById(Integer userId) {
		return userDomain.getUserById(userId);
	}

	@Override
	public void deleteListUser(List<Integer> ids) {
		for (Integer id : ids) {
			this.deleteUserById(id);
		}
	}

	@Override
	public void deleteUserById(Integer userId) {
		userDomain.deleteUserById(userId);
	}

	@Override
	public User saveUser(User user) {

		return userDomain.saveUser(user);
	}

	@Override
	public Page<User> searchUser(String searchTerm, Pageable pageRequest) {

		return null;
	}

	@Override
	public List<User> searchUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<User> getAllUser(Pageable pageRequest) {
		// TODO Auto-generated method stub
		return userDomain.getAllUser(pageRequest);
	}

	@Override
	public PagingOutputDTO<User> searchUser(PagingInputDTO pagingInput) {
		return userDomain.searchUser(pagingInput);
	}

	@Override
	public List<String> getListFeature(Integer userId) {
		User user = userDomain.getUserById(userId);
		List<Group> groupList = user.getGroups();
		List<Permission> permissionList = new ArrayList<Permission>();
		for (Group group : groupList) {
			permissionList.addAll(group.getPermissions());
		}
		Set<String> featureList = new HashSet<String>();
		for (Permission permission : permissionList) {
			String menuPath=permission.getMenuPath();
			if (permission.getToggle() && menuPath!=null && !menuPath.isEmpty()) {
				featureList.addAll(Arrays.asList(permission.getMenuPath().trim().split("\\\\")));
			}
		}
		return new ArrayList<String>(featureList);
	}

}
