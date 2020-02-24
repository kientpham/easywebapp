package com.kientpham.webapp.commonlib.userserviceclient.dto;
import java.util.UUID;
import java.util.List;
import com.kientpham.webapp.userservice.group.Group;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupEditDTO{
	private Integer id;
	private String name;
	private Integer status;
	private String description;
	private List<UUID> users;
	private List<String> permissions;

	public GroupEditDTO() {
		//default constructor
	}
	public GroupEditDTO(Group group) {
		if(group !=null){
			this.id=group.getId();
			this.name=group.getName();
			this.status=group.getStatus();
			this.description=group.getDescription();
		}
	}

}