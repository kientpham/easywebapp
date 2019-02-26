package com.kienp.webapp.application.interactor.user.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kienp.webapp.application.interactor.user.UserEditInteractor;
import com.kienp.webapp.application.model.user.GroupListJoinUser;
import com.kienp.webapp.application.model.user.UserEdit;
import com.kienp.webapp.application.presenter.user.UserEditPresenter;
import com.kienp.webapp.userservice.entity.Group;
import com.kienp.webapp.userservice.entity.User;
import com.kienp.webapp.userservice.service.GroupService;
import com.kienp.webapp.userservice.service.UserService;

public class UserEditInteractorImp implements UserEditInteractor{

	@Autowired
	private UserEditPresenter userEditPresenter;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private GroupService groupService;	
	
	
	@Override
	public UserEdit getUserForEdit(Integer id) {	
		return userEditPresenter.buildUserEdit(userService.getUserById(id));				
	}
	
	@Override
	public String saveUser(UserEdit user) {
		User newUser= userService.saveUser(this.getUserEntity(user));
		return String.format("The user %s have been saved succesfully!", newUser.getUserName());
	}
	
	@Override
	public List<GroupListJoinUser> getGroupListJoinUser(Integer userId) {
		List<GroupListJoinUser> returnList=new ArrayList<GroupListJoinUser>();		
		for (Group group: groupService.getAllGroup()) {
			GroupListJoinUser groupJoinUser=new GroupListJoinUser();
			groupJoinUser.setGroupId(group.getId());
			groupJoinUser.setGroupName(group.getName());
			List<Group>userGroupAll= userService.getUserById(userId).getGroups();
			if (userGroupAll!=null) {
				for (Group userGroup:userGroupAll) {
					if (group.getId()==userGroup.getId()) {
						groupJoinUser.setIsUserIn("checked");
						break;
					}
				}
			}
			returnList.add(groupJoinUser);
		}		
		return returnList;// groupRepository.getGroupListJoinUser(userId);
	}	
	
	private User getUserEntity(UserEdit eUser) {
		User user=new User();
		user.setId(eUser.getId());
		user.setUserName(eUser.getUsername());
		user.setPassword(eUser.getPassword());
		user.setFirstName(eUser.getFirstName());
		user.setLastName(eUser.getLastName());
		user.setEmail(eUser.getEmail());
		user.setUserType(eUser.getUserType());
		user.setStatus(eUser.getUserStatus());
		user.setAddress(eUser.getAddress());
		user.setGroups(groupService.getGroupListByIds(eUser.getTblUserGroup()));
		return user;
	} 
	
}
