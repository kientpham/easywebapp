package com.datatransforming.baseapp.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.datatransforming.baseapp.presenter.input.PaginationCriteria;
import com.datatransforming.baseapp.presenter.input.TablePage;
import com.datatransforming.baseapp.presenter.input.User;
import com.datatransforming.baseapp.presenter.input.UserSearch;
import com.datatransforming.baseapp.presenter.ouput.GroupListJoinUser;
import com.datatransforming.baseapp.presenter.ouput.UserDataTable;
import com.datatransforming.baseapp.presenter.ouput.UserEdit;
import com.datatransforming.baseapp.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	private static final List<User> TEST_DATA = Arrays.asList(new User(1, "Lisa", 20), new User(2, "Tom", 31),
			new User(3, "David", 38), new User(4, "Marco", 23), new User(5, "Jenny", 15));
	 private ObjectMapper objectMapper = new ObjectMapper();
	
	@RequestMapping(value="/paginated", method=RequestMethod.POST)
	@ResponseBody
	public TablePage listUsersPaginated(@RequestBody PaginationCriteria paginationCriteria) {
		 TablePage page = new TablePage();
	        page.setDraw(paginationCriteria.getDraw());	       

	        page.setRecordsTotal(TEST_DATA.size());	        

	        page.setRecordsFiltered(TEST_DATA.size());//dataService.countFilteredEntries(paginationCriteria));	        

	        
	        List<User> data = TEST_DATA.stream().filter(u->u.getName().contains(paginationCriteria.getSearch().getValue())).collect(Collectors.toList()).subList(paginationCriteria.getStart(), paginationCriteria.getStart()+2);
	     
	        List<Map<String, String>> records = new ArrayList<>(data.size());
	        try {
	            data.forEach(i -> {
	                Map<String, Object> m = objectMapper.convertValue(i, Map.class);
	                records.add(m.entrySet().stream()
	                        .collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue().toString())));
	            });
	  
	        } catch (Exception e) {
	      
	        }  
	        
	        page.setData(records);
	        
		return page;
	}
	
	
	@RequestMapping(value="/getUserDataTable",method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<UserDataTable> getUserTable(@RequestBody UserSearch user) {
		return userService.getUserList(user);
	}

	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public ResponseEntity<UserEdit> getUser(@RequestParam(value = "id") Integer id) {
		// return userService.getUserForEdit(id);
		ResponseEntity<UserEdit> entity = new ResponseEntity<UserEdit>(userService.getUserForEdit(id), HttpStatus.OK);
		return entity;
	}
	
	@RequestMapping(value = "/getUserSearchForm", method = RequestMethod.GET)
	public ResponseEntity<UserSearch> getUserSearchForm(@RequestParam(value = "id") Integer id) {
		ResponseEntity<UserSearch> entity = new ResponseEntity<UserSearch>(new UserSearch(), HttpStatus.OK);
		return entity;
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)  
	  public ResponseEntity<String> addAccount(@RequestBody(required = true) UserEdit userEdit)
	  {	    
	    return new ResponseEntity<String>(userService.saveUser(userEdit),HttpStatus.OK);
	  }
	
	 @RequestMapping(value = "/deleteUsers", method = RequestMethod.POST)
	  public String deleteUsers(@RequestBody(required = true) List<Integer> ids)
	  {
		 return userService.deleteUsers(ids);
	    //return "The accounts have been deleted successfully!";
	  }
	 	 
	 @RequestMapping(value="/getGroupUserList", method = RequestMethod.POST)
	 public List<GroupListJoinUser> getGroupListJoinUser(@RequestBody(required = true) int id){		 
		 return userService.getGroupListJoinUser(id);
	 }

}
