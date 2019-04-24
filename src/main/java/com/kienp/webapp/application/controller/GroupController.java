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

import com.kienp.webapp.application.model.group.GroupEdit;
import com.kienp.webapp.application.model.group.GroupTable;
import com.kienp.webapp.application.model.permission.PermissionJoinGroupList;
import com.kienp.webapp.application.presenter.group.GroupEditPresenter;
import com.kienp.webapp.application.presenter.group.GroupListPresenter;

@RestController
public class GroupController {

	@Autowired
	private GroupListPresenter groupListConnector;

	@Autowired
	private GroupEditPresenter groupEditConnector;

	@RequestMapping(value = "/getAllGroup", method = RequestMethod.POST)
	public List<GroupTable> getAllGroup() {
		return groupListConnector.getListGroupTable();
	}

	@RequestMapping(value = "/deleteGroups", method = RequestMethod.POST)
	public String deleteGroups(@RequestBody(required = true) List<Integer> ids) {
		return groupListConnector.deleteGroups(ids);
	}

	@RequestMapping(value = "/getGroup", method = RequestMethod.GET)
	public ResponseEntity<GroupEdit> getGroup(@RequestParam(value = "id") Integer id) {
		return new ResponseEntity<GroupEdit>(groupEditConnector.getGroupEdit(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/saveGroup", method = RequestMethod.POST)
	public String saveGroup(@RequestBody(required = true) GroupEdit groupEdit) {
		return groupEditConnector.saveGroup(groupEdit);
	}
	
	@RequestMapping(value="/getPermissionGroupList", method=RequestMethod.POST)
	public List<PermissionJoinGroupList> getPermissionJoinGroupList(@RequestBody(required=true) int id){
		return groupEditConnector.getPermissionListJoinGroup(id);
	}

}
