package com.datatransforming.baseapp.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.datatransforming.baseapp.entity.Group;
import com.datatransforming.baseapp.entity.User;
import com.datatransforming.baseapp.presenter.UserPresenter;
import com.datatransforming.baseapp.presenter.input.UserSearch;
import com.datatransforming.baseapp.presenter.ouput.GroupListJoinUser;
import com.datatransforming.baseapp.presenter.ouput.UserDataTable;
import com.datatransforming.baseapp.presenter.ouput.UserEdit;
import com.datatransforming.baseapp.repository.GroupRepository;
import com.datatransforming.baseapp.repository.UserRepository;
import com.datatransforming.baseapp.service.UserService;

@Component
public class UserServiceImp implements UserService{
	
	@Autowired
	private UserPresenter presenter;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private GroupRepository groupRepository;
	
	@Override
	public List<UserDataTable> getUserList(UserSearch user) {		
		if (user.getUserStatusSearch()==0 && user.getName()==Strings.EMPTY) {
			return presenter.getUserDataTable((List<User>) userRepository.findTop20ByOrderByFirstNameAsc());	
		}else {
			return null;
		}
		
	}

	@Override
	public UserEdit getUserForEdit(Integer id) {	
		return presenter.buildUserEdit(userRepository.findById(id).orElse(new User()));				
	}

	@Override
	public String saveUser(UserEdit user) {
		User newUser= userRepository.save(this.getUserEntity(user));
		return String.format("The user %s have been saved succesfully!", newUser.getUserName());
	}

	@Override
	public String deleteUsers(List<Integer> ids) {
		for (Integer id:ids) {
			userRepository.deleteById(id);	
		}		
		return "User has been deleted";
	}

	@Override
	public List<GroupListJoinUser> getGroupListJoinUser(Integer userId) {
		List<GroupListJoinUser> returnList=new ArrayList<GroupListJoinUser>();		
		for (Group group: groupRepository.findAll()) {
			GroupListJoinUser groupJoinUser=new GroupListJoinUser();
			groupJoinUser.setGroupId(group.getId());
			groupJoinUser.setGroupName(group.getName());
			List<Group>userGroupAll= userRepository.findById(userId).orElse(new User()).getGroups();
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
		user.setGroups(groupRepository.findByIdIn(eUser.getTblUserGroup()));
		return user;
	} 
}
