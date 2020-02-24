package com.kientpham.webapp.commonlib.userserviceclient.dto;
import com.kientpham.webapp.userservice.permission.Permission;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PermissionTableDTO{
	private String id;
	private String name;
	private String menuPath;
	private String url;
	private String icon;
	private String description;
	private String type;
	private String toggle;

	public PermissionTableDTO(Permission permission, Map<Integer,String> lookupMap) {
		if(permission !=null){
			this.id=permission.getId();
			this.name=permission.getName();
			this.menuPath=permission.getMenuPath();
			this.url=permission.getUrl();
			this.icon=permission.getIcon();
			this.description=permission.getDescription();
			this.type=lookupMap.get(permission.getType());
			if (permission.getToggle()!=null)
				this.toggle=permission.getToggle().toString();
		}
	}
}