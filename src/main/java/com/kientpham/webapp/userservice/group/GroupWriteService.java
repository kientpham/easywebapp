package com.kientpham.webapp.userservice.group;
import java.util.List;
import com.kientpham.webapp.userservice.group.Group;
import com.kientpham.webapp.commonlib.userserviceclient.dto.GroupEditDTO;


public interface GroupWriteService{

	public void deleteGroupById(Integer id);


	public void deleteListGroup(List<Integer> ids);

	public GroupEditDTO saveGroup(GroupEditDTO groupEditDTO);

}