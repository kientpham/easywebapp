package com.kienp.webapp.application.model.user;

import java.util.Map;

import com.kienp.webapp.userservice.dto.entity.Group;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupTable {

	private Integer id;
	
	private String groupName;	
	
	private String status;
	
	private String description;
	
	public GroupTable(Group group,Map<Integer,String> categoryMap) {
		this.setId(group.getId());
		this.setGroupName(group.getName());
		this.setDescription(group.getDescription());
		this.setStatus(categoryMap.get(group.getStatus()));
	}
}
