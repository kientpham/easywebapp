package com.datatransforming.baseapp.presenter.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.datatransforming.baseapp.common.CategoryGroupName;
import com.datatransforming.baseapp.entity.Category;
import com.datatransforming.baseapp.entity.User;
import com.datatransforming.baseapp.presenter.UserPresenter;
import com.datatransforming.baseapp.presenter.input.PaginationCriteria;
import com.datatransforming.baseapp.presenter.input.TablePage;
import com.datatransforming.baseapp.presenter.ouput.UserDataTable;
import com.datatransforming.baseapp.presenter.ouput.UserEdit;
import com.datatransforming.baseapp.repository.CategoryRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class UserPresenterImp implements UserPresenter{

	@Autowired
	private CategoryRepository categoryRepo;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
	public List<UserDataTable> getUserDataTable(List<User> users) {
		
		List<UserDataTable> returnList=new ArrayList<UserDataTable>();
		List<Category> userCategoryList=new ArrayList<Category>();
		userCategoryList.addAll(categoryRepo.findByCategoryGroup(CategoryGroupName.USER_TYPE));
		userCategoryList.addAll(categoryRepo.findByCategoryGroup(CategoryGroupName.USER_STATUS));		
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

	@Override
	public TablePage buildTablePage(List<User> userList,List<User> userFilteredList, PaginationCriteria criteria) {
		TablePage page = new TablePage();
		page.setDraw(criteria.getDraw());
		page.setRecordsTotal(userList.size());
		page.setRecordsFiltered(userList.size());
		List<Category> userCategoryList=new ArrayList<Category>();
		userCategoryList.addAll(categoryRepo.findByCategoryGroup(CategoryGroupName.USER_TYPE));
		userCategoryList.addAll(categoryRepo.findByCategoryGroup(CategoryGroupName.USER_STATUS));
		List<Map<String, String>> records = new ArrayList<>(userFilteredList.size());
//		try {
//			for (User user : userFilteredList) {
//				Map<String, String> m = objectMapper.convertValue(user, Map.class);
//				records.add(m.entrySet().stream()
//						 .collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue().toString())));	
//			}
			
//			userFilteredList.forEach(i -> {
//				 Map<String, Object> m = objectMapper.convertValue(i, Map.class);
//				 Map<String, Object> n =new HashMap<String, Object>();
//				 Iterator it=m.entrySet().iterator();
//				 int c=0;
//				 while (it.hasNext()) {
//					  Map.Entry pair = (Map.Entry)it.next();				  
//					 n.put(Integer.toString(c), pair.getValue().toString());
//					 c++;
//				 }
//				 
//				 records.add(n.entrySet().stream()
//				 .collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue().toString())));
//			 });
//
//		} catch (Exception e) {
//
//		}
		
		
		for (User user : userFilteredList) {
			Map<String, String> m = new HashMap<String, String>();
			m.put("0", Integer.toString(user.getId()));
			m.put("1", user.getUserName());
			m.put("2", user.getFirstName()+ " " + user.getLastName());
			m.put("3", user.getEmail());
			for(Category cat:userCategoryList) {
				if (cat.getId()== user.getUserType()) {
					m.put("4", cat.getValue());					
				}
				if(cat.getId()==user.getStatus()) {
					m.put("5", cat.getValue());
				}		
			}
			m.put("6", user.getAddress());
			records.add(m);
		}
		page.setData(records);		
		return page;
	}

}
