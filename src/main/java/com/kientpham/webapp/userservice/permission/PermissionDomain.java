package com.kientpham.webapp.userservice.permission;
import java.util.Set;
import java.util.ArrayList;
import com.kientpham.webapp.commonlib.userserviceclient.dto.PermissionJoinListDTO;
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
	

	public List<PermissionJoinListDTO> getPermissionJoinListDTO(Set<Integer> ids) {
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
	
	public List<Permission> findByListIds(List<Integer> ids){
		return dbGateway.findByListIds(ids);
	}
	
	public Permission findById(Integer id) {
		if (id==null) return null;
		return dbGateway.findById(id);
	}

	public void deleteById(Integer id) {
		dbGateway.deleteById(id);
	}
	
	public Permission save(Permission entity) {
		return dbGateway.save(entity);
	}

	public Permission getPermissionEntity(PermissionEditDTO permissionEditDTO) {
		Permission permission=new Permission();
		permission.setId(permissionEditDTO.getId());
		permission.setName(permissionEditDTO.getName());
		permission.setToggle(permissionEditDTO.getToggle());
		permission.setMenuPath(permissionEditDTO.getMenuPath());
		permission.setUrl(permissionEditDTO.getUrl());
		permission.setIcon(permissionEditDTO.getIcon());
		permission.setDescription(permissionEditDTO.getDescription());
		permission.setType(permissionEditDTO.getType());
		return permission;
	}

}