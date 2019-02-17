package com.datatransforming.baseapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.datatransforming.baseapp.presenter.input.UserSearch;
import com.datatransforming.baseapp.presenter.ouput.GroupListJoinUser;
import com.datatransforming.baseapp.presenter.ouput.UserDataTable;
import com.datatransforming.baseapp.presenter.ouput.UserEdit;
import com.datatransforming.baseapp.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
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
