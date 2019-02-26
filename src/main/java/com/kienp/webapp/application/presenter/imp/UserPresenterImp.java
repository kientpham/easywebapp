package com.kienp.webapp.application.presenter.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kienp.webapp.application.model.PaginationCriteria;
import com.kienp.webapp.application.model.TablePage;
import com.kienp.webapp.application.model.UserDataTable;
import com.kienp.webapp.application.presenter.UserPresenter;
import com.kienp.webapp.userservice.entity.Category;
import com.kienp.webapp.userservice.entity.User;
import com.kienp.webapp.userservice.model.UserEdit;

@Component
public class UserPresenterImp implements UserPresenter{

	
	ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
	public List<UserDataTable> getUserDataTable(List<User> users, List<Category> userCategoryList) {
		
		List<UserDataTable> returnList=new ArrayList<UserDataTable>();
		for(User user:users) {
			returnList.add(this.buildUserDataTable(user, userCategoryList));
		}		
		return returnList;
	}
	
	
	@Override
	public UserEdit buildUserEdit(User user) {
		UserEdit userEdit=new UserEdit();
		if (user != null) {
			userEdit.setId(user.getId());
			userEdit.setUsername(user.getUserName());
			userEdit.setFirstName(user.getFirstName());
			userEdit.setPassword(user.getPassword());
			userEdit.setLastName(user.getLastName());
			userEdit.setEmail(user.getEmail());
			userEdit.setUserType(user.getUserType());
			userEdit.setUserStatus(user.getStatus());
			userEdit.setAddress(user.getAddress());
		}		
		return userEdit;
	}
	
	private UserDataTable buildUserDataTable(User user, List<Category> categoryList){
		UserDataTable userData=new UserDataTable();
		userData.setId(user.getId());
		userData.setUserName(user.getUserName());
		userData.setFullName(user.getFirstName() + " " + user.getLastName());
		userData.setEmail(user.getEmail());
		userData.setAddress(user.getAddress());
		for(Category cat:categoryList) {
			if (cat.getId()== user.getUserType()) {
				userData.setType(cat.getValue());
				continue;
			}
			if(cat.getId()==user.getStatus()) {
				userData.setStatus(cat.getValue());
			}		
		}
		return userData;
	}
	
	private List<UserDataTable> getListUserDataTable(List<User> userList,List<Category> categoryList){
		List<UserDataTable> list =new ArrayList<UserDataTable>();
		for (User user:userList) {
			list.add(this.buildUserDataTable(user, categoryList));
		}			
		return list;
	} 

	@Override
	public TablePage buildTablePage(List<Category> userCategoryList, List<User> userList,List<User> userFilteredList, PaginationCriteria criteria) {
		TablePage page = new TablePage();
		page.setDraw(criteria.getDraw());
		page.setRecordsTotal(userList.size());
		page.setRecordsFiltered(userList.size());
		
		List<Map<String, String>> records = new ArrayList<>(userFilteredList.size());
		
		List<UserDataTable> listUser=  getListUserDataTable(userFilteredList,userCategoryList); 
				
		listUser.forEach(i -> {				
				Map<String, Object> m = objectMapper.convertValue(i, new TypeReference<Map<String, Object>>(){});
				 Map<String, Object> n =new HashMap<String, Object>();
				 Iterator it=m.entrySet().iterator();
				 int c=0;
				 while (it.hasNext()) {
					  Map.Entry pair = (Map.Entry)it.next();				  
					 n.put(Integer.toString(c), pair.getValue().toString());
					 c++;
				 }				 
				 records.add(n.entrySet().stream()
				 .collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue().toString())));
			 });		

		page.setData(records);		
		return page;
	}

}
