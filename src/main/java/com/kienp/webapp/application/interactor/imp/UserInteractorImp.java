package com.kienp.webapp.application.interactor.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kienp.webapp.application.interactor.UserInteractor;
import com.kienp.webapp.application.model.GroupListJoinUser;
import com.kienp.webapp.application.model.PaginationCriteria;
import com.kienp.webapp.application.model.TablePage;
import com.kienp.webapp.application.model.UserDataTable;
import com.kienp.webapp.application.presenter.UserPresenter;
import com.kienp.webapp.common.Constants;
import com.kienp.webapp.userservice.entity.Category;
import com.kienp.webapp.userservice.entity.Group;
import com.kienp.webapp.userservice.entity.User;
import com.kienp.webapp.userservice.model.UserEdit;
import com.kienp.webapp.userservice.model.UserSearch;
import com.kienp.webapp.userservice.service.CategoryService;
import com.kienp.webapp.userservice.service.GroupService;
import com.kienp.webapp.userservice.service.UserService;

@Component
public class UserInteractorImp implements UserInteractor{
	
	@Autowired
	private UserPresenter presenter;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private GroupService groupService;	
	
	@Autowired 
	private CategoryService categoryService;
		
	
	@Override
	public List<UserDataTable> getUserList(UserSearch user) {		
		if (user.getUserStatusSearch()==0 && user.getName()==Strings.EMPTY) {
			return presenter.getUserDataTable(userService.getAllUsers(), this.getListUserCategory());	
		}else {
			return null; //TODO
		}		
	}
	
	
	@Override
	public TablePage getUsersListAjax(PaginationCriteria paginationCriteria) {		
		List<User> userList= userService.getAllUsers();
		List<User> filteredUser= userList.stream()
				.filter(u -> u.getFirstName().contains(paginationCriteria.getSearch().getValue()))
				.collect(Collectors.toList()).subList(paginationCriteria.getStart(), paginationCriteria.getStart() + paginationCriteria.getLength());
		//List<User> filteredUser= userList.subList(paginationCriteria.getStart(), paginationCriteria.getStart() + paginationCriteria.getLength());
		return presenter.buildTablePage(this.getListUserCategory() ,userList, filteredUser, paginationCriteria);		
	}

	@Override
	public UserEdit getUserForEdit(Integer id) {	
		return presenter.buildUserEdit(userService.getUserById(id));				
	}

	@Override
	public String saveUser(UserEdit user) {
		User newUser= userService.saveUser(this.getUserEntity(user));
		return String.format("The user %s have been saved succesfully!", newUser.getUserName());
	}

	@Override
	public String deleteUsers(List<Integer> ids) {
		for (Integer id:ids) {
			userService.deleteUserById(id);	
		}		
		return "User has been deleted";
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
	
	private List<Category> getListUserCategory() {
		List<String> userCatList= new ArrayList<String>();
		userCatList.add(Constants.USER_TYPE);
		userCatList.add(Constants.USER_STATUS);		
		return categoryService.getCategoryByGroups(userCatList);
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
