package com.kienp.webapp.application.presenter.group;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kienp.webapp.application.model.group.GroupTable;
import com.kienp.webapp.userservice.dto.entity.Group;
import com.kienp.webapp.userservice.service.CategoryService;
import com.kienp.webapp.userservice.service.GroupService;

@Component
public class GroupListPresenter {

	@Autowired
	private GroupService groupService;
	
	@Autowired
	private CategoryService categoryService;
	
	public List<GroupTable> getListGroupTable(){
		
		Map<Integer, String> mapCategory=categoryService.getMapAllCategory();
		List<Group> allGroup= groupService.getAllGroup();
		List<GroupTable> allGroupTable=new ArrayList<GroupTable>();
		for(Group group:allGroup) {
			allGroupTable.add(new GroupTable(group, mapCategory));
		}
		return allGroupTable;
	}
	
	public String deleteGroups(List<Integer> ids) {
		groupService.deleteListGroup(ids);
		return "Group has been deleted!";
	}
}
