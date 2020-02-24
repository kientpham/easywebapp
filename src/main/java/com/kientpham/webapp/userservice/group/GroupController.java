package com.kientpham.webapp.userservice.group;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.kientpham.webapp.commonlib.userserviceclient.dto.GroupEditDTO;
import com.kientpham.webapp.commonlib.userserviceclient.dto.GroupTableDTO;
import com.kientpham.webapp.userservice.group.GroupReadService;
import com.kientpham.webapp.commonlib.userserviceclient.dto.UserJoinListDTO;
import com.kientpham.webapp.commonlib.userserviceclient.dto.PermissionJoinListDTO;

@RestController
@RequestMapping(value="/userservice/groups")
public class GroupController{
	@Autowired
	private GroupReadService groupReadService;
	@Autowired
	private GroupWriteService groupWriteService;

	@RequestMapping(value="/grouptabledto", method=RequestMethod.GET)
	public List<GroupTableDTO> getGroupTableDTO(){
		return groupReadService.getListGroupTableDTO();		
	}

	@RequestMapping(value="/userjoinlistdto", method=RequestMethod.GET)
	public List<UserJoinListDTO> getUserJoinListDTO(@RequestParam Integer id){
		return groupReadService.getUserJoinListDTO(id);
	}
	@RequestMapping(value="/permissionjoinlistdto", method=RequestMethod.GET)
	public List<PermissionJoinListDTO> getPermissionJoinListDTO(@RequestParam Integer id){
		return groupReadService.getPermissionJoinListDTO(id);
	}
	@RequestMapping(value="groupeditdto",method=RequestMethod.GET)
	public ResponseEntity<GroupEditDTO> getgroupeditdto(@RequestParam Integer id){
		return new ResponseEntity<GroupEditDTO>(groupReadService.getGroupEditDTOById(id),HttpStatus.OK);
	}

	@RequestMapping(value="/groupeditdto", method=RequestMethod.POST)
	public String saveGroup(@RequestBody(required=true) GroupEditDTO groupEditDTO) {
		groupWriteService.saveGroup(groupEditDTO);
		return "Saved Successfully!";
	}

	@RequestMapping(method=RequestMethod.DELETE)
	public String deleteGroup(@RequestBody(required=true) Integer id) {
		groupWriteService.deleteGroupById(id);
		return "Successfully";
	}

}