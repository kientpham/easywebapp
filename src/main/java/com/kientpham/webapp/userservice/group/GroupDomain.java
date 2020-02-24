package com.kientpham.webapp.userservice.group;
import java.util.Set;
import java.util.ArrayList;
import com.kientpham.webapp.commonlib.userserviceclient.dto.GroupJoinListDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kientpham.webapp.userservice.group.Group;
import com.kientpham.webapp.userservice.group.GroupDBGateway;
import com.kientpham.webapp.commonlib.userserviceclient.dto.GroupEditDTO;

@Component
public class GroupDomain{
	@Autowired
	private GroupDBGateway dbGateway;
	

	public List<GroupJoinListDTO> getGroupJoinListDTO(Set<Integer> ids) {
		List<GroupJoinListDTO> returnList=new ArrayList<GroupJoinListDTO>(); 
		List<Group> allGroup=this.findAll(); 
		for (Group group: allGroup) {
			GroupJoinListDTO groupJoin=new GroupJoinListDTO();
			groupJoin.setId(group.getId());
			groupJoin.setName(group.getName());
			if (ids!=null && ids.contains(group.getId())) {
				groupJoin.setIsChecked("checked");
			}
			returnList.add(groupJoin);
		} 
 		return returnList;
	}

	public List<Group> findAll(){
		return dbGateway.findAll();
	}
	
	public List<Group> findByListIds(List<Integer> ids){
		return dbGateway.findByListIds(ids);
	}
	
	public Group findById(Integer id) {
		if (id==null) return null;
		return dbGateway.findById(id);
	}

	public void deleteById(Integer id) {
		dbGateway.deleteById(id);
	}
	
	public Group save(Group entity) {
		return dbGateway.save(entity);
	}

	public Group getGroupEntity(GroupEditDTO groupEditDTO) {
		Group group=new Group();
		group.setId(groupEditDTO.getId());
		group.setName(groupEditDTO.getName());
		group.setStatus(groupEditDTO.getStatus());
		group.setDescription(groupEditDTO.getDescription());
		return group;
	}

}