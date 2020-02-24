package com.kientpham.webapp.commonlib.userserviceclient.dto;
import java.util.List;
import com.kientpham.webapp.userservice.permission.Permission;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PermissionEditDTO{
	private String id;
	private String name;
	private String menuPath;
	private String url;
	private String icon;
	private String description;
	private Integer type;
	private Boolean toggle;
	private List<Integer> groups;

	public PermissionEditDTO() {
		//default constructor
	}
	public PermissionEditDTO(Permission permission) {
		if(permission !=null){
			this.id=permission.getId();
			this.name=permission.getName();
			this.menuPath=permission.getMenuPath();
			this.url=permission.getUrl();
			this.icon=permission.getIcon();
			this.description=permission.getDescription();
			this.type=permission.getType();
			this.toggle=permission.getToggle();
		}
	}

}