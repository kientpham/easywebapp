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
	private String status;
	private String description;

	public GroupTableDTO(Group group, Map<Integer,String> lookupMap) {
		if(group !=null){
			if (group.getId()!=null)
				this.id=group.getId();
			this.name=group.getName();
			this.status=lookupMap.get(group.getStatus());
			this.description=group.getDescription();
		}
	}
}