package com.kienp.webapp.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kienp.webapp.application.model.group.GroupJoinOtherList;
import com.kienp.webapp.application.model.permission.PermissionEdit;
import com.kienp.webapp.application.model.permission.PermissionTable;
import com.kienp.webapp.application.presenter.permission.PermissionEditPresenter;
import com.kienp.webapp.application.presenter.permission.PermissionListPresenter;

@RestController
public class PermissionController {

	@Autowired
	private PermissionListPresenter permissionListPresenter;
	
	@Autowired
	private PermissionEditPresenter premissionEditPresenter;
	
	@RequestMapping(value="/getPermissionTable", method=RequestMethod.POST)
	public List<PermissionTable> getPermissionTable(){
		return permissionListPresenter.getListPermissionTable();		
	}
	
	@RequestMapping(value="/deletePermission", method=RequestMethod.POST)
	public String deletePermission(@RequestBody(required=true) List<Integer> ids) {
		return permissionListPresenter.deletePermissions(ids);
	}
	
	@RequestMapping(value="/getPermission",method=RequestMethod.GET)
	public ResponseEntity<PermissionEdit> getPermission(@RequestParam(value="id") Integer id){
		return new ResponseEntity<PermissionEdit>(premissionEditPresenter.getPermissionEdit(id),HttpStatus.OK);
	}
	
	@RequestMapping(value="/getGroupPermissionList", method=RequestMethod.POST)
	public List<GroupJoinOtherList> getGroupJoinPermissionList(@RequestBody(required=true) int id){
		return premissionEditPresenter.getGroupJoinPermissionList(id);
	}
	
	@RequestMapping(value="/savePermission", method=RequestMethod.POST)
	public String savePermission(@RequestBody(required=true) PermissionEdit permissionEdit) {
		return premissionEditPresenter.savePermission(permissionEdit);
	}
	
}
