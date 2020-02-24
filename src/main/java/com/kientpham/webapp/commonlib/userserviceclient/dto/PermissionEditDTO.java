package com.kientpham.webapp.commonlib.userserviceclient.dto;
import java.util.List;
import com.kientpham.webapp.userservice.permission.Permission;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PermissionEditDTO{
	private Integer id;
	private String name;
	private Boolean toggle;
	private String menuPath;
	private String url;
	private String icon;
	private String description;
	private Integer type;
	private List<Integer> groups;

	public PermissionEditDTO() {
		//default constructor
	}
	public PermissionEditDTO(Permission permission) {
		if(permission !=null){
			this.id=permission.getId();
			this.name=permission.getName();
			this.toggle=permission.getToggle();
			this.menuPath=permission.getMenuPath();
			this.url=permission.getUrl();
			this.icon=permission.getIcon();
			this.description=permission.getDescription();
			this.type=permission.getType();
		}
	}
}