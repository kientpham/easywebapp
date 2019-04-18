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

import com.kienp.webapp.application.connector.group.GroupEditConnector;
import com.kienp.webapp.application.connector.group.GroupListConnector;
import com.kienp.webapp.application.model.user.GroupEdit;
import com.kienp.webapp.application.model.user.GroupTable;

@RestController
public class GroupController {

	@Autowired
	private GroupListConnector groupListConnector;

	@Autowired
	private GroupEditConnector groupEditConnector;

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

}
