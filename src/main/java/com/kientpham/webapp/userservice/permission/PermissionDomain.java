package com.kientpham.webapp.userservice.permission;
import java.util.Set;
import java.util.ArrayList;
import com.kientpham.webapp.commonlib.userserviceclient.dto.PermissionJoinListDTO;
import com.kientpham.webapp.commonlib.utils.DateStringUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kientpham.webapp.userservice.permission.Permission;
import com.kientpham.webapp.userservice.permission.PermissionDBGateway;
import com.kientpham.webapp.commonlib.userserviceclient.dto.PermissionEditDTO;

@Component
public class PermissionDomain{
	@Autowired
	private PermissionDBGateway dbGateway;
	

	public List<PermissionJoinListDTO> getPermissionJoinListDTO(Set<String> ids) {
		List<PermissionJoinListDTO> returnList=new ArrayList<PermissionJoinListDTO>(); 
		List<Permission> allPermission=this.findAll(); 
		for (Permission permission: allPermission) {
			PermissionJoinListDTO permissionJoin=new PermissionJoinListDTO();
			permissionJoin.setId(permission.getId());
			permissionJoin.setName(permission.getName());
			if (ids!=null && ids.contains(permission.getId())) {
				permissionJoin.setIsChecked("checked");
			}
			returnList.add(permissionJoin);
		} 
 		return returnList;
	}

	public List<Permission> findAll(){
		return dbGateway.findAll();
	}
	
	public List<Permission> findByListIds(List<String> ids){
		return dbGateway.findByListIds(ids);
	}
	
	public Permission findById(String id) {
		if (id==null) return null;
		return dbGateway.findById(id);
	}

	public void deleteById(String id) {
		dbGateway.deleteById(id);
	}
	
	public Permission save(Permission entity) {
		return dbGateway.save(entity);
	}

	public Permission getPermissionEntity(PermissionEditDTO permissionEditDTO) {
		Permission permission=new Permission();
		if (permissionEditDTO.getId().isEmpty()) {
			permissionEditDTO.setId(DateStringUtils.getRandomString(8));
					}
		permission.setId(permissionEditDTO.getId());
		permission.setName(permissionEditDTO.getName());
		permission.setMenuPath(permissionEditDTO.getMenuPath());
		permission.setUrl(permissionEditDTO.getUrl());
		permission.setIcon(permissionEditDTO.getIcon());
		permission.setDescription(permissionEditDTO.getDescription());
		permission.setType(permissionEditDTO.getType());
		permission.setToggle(permissionEditDTO.getToggle());
		return permission;
	}

}