package com.kientpham.webapp.commonlib.userserviceclient.dto;
import com.kientpham.webapp.userservice.group.Group;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupTableDTO{
	private Integer id;
	private String name;
	private String description;
	private String status;

	public GroupTableDTO(Group group,Map<Integer,String> lookupMap) {
		if(group !=null){
			this.id=group.getId();
			this.name=group.getName();
			this.description=group.getDescription();
			this.status=lookupMap.get(group.getStatus());
		}
	}
}