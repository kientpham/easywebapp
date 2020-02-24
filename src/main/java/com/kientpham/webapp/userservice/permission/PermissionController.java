package com.kientpham.webapp.userservice.permission;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.kientpham.webapp.commonlib.userserviceclient.dto.PermissionEditDTO;
import com.kientpham.webapp.commonlib.userserviceclient.dto.PermissionTableDTO;
import com.kientpham.webapp.userservice.permission.PermissionReadService;
import com.kientpham.webapp.commonlib.userserviceclient.dto.GroupJoinListDTO;

@RestController
@RequestMapping(value="/userservice/permissions")
public class PermissionController{
	@Autowired
	private PermissionReadService permissionReadService;
	@Autowired
	private PermissionWriteService permissionWriteService;

	@RequestMapping(value="/permissiontabledto", method=RequestMethod.GET)
	public List<PermissionTableDTO> getPermissionTableDTO(){
		return permissionReadService.getListPermissionTableDTO();		
	}

	@RequestMapping(value="/groupjoinlistdto", method=RequestMethod.GET)
	public List<GroupJoinListDTO> getGroupJoinListDTO(@RequestParam Integer id){
		return permissionReadService.getGroupJoinListDTO(id);
	}
	@RequestMapping(value="permissioneditdto",method=RequestMethod.GET)
	public ResponseEntity<PermissionEditDTO> getpermissioneditdto(@RequestParam Integer id){
		return new ResponseEntity<PermissionEditDTO>(permissionReadService.getPermissionEditDTOById(id),HttpStatus.OK);
	}

	@RequestMapping(value="/permissioneditdto", method=RequestMethod.POST)
	public String savePermission(@RequestBody(required=true) PermissionEditDTO permissionEditDTO) {
		permissionWriteService.savePermission(permissionEditDTO);
		return "Saved Successfully!";
	}

	@RequestMapping(method=RequestMethod.DELETE)
	public String deletePermission(@RequestBody(required=true) Integer id) {
		permissionWriteService.deletePermissionById(id);
		return "Successfully";
	}

}