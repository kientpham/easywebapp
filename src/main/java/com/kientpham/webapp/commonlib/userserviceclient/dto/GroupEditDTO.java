package com.kientpham.webapp.commonlib.userserviceclient.dto;
import java.util.List;
import com.kientpham.webapp.userservice.group.Group;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupEditDTO{
	private Integer id;
	private String name;
	private String description;
	private Integer status;
	private List<Integer> users;
	private List<Integer> permissions;

	public GroupEditDTO() {
		//default constructor
	}
	public GroupEditDTO(Group group) {
		if(group !=null){
			this.id=group.getId();
			this.name=group.getName();
			this.description=group.getDescription();
			this.status=group.getStatus();
		}
	}
}