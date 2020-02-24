package com.kientpham.webapp.userservice.user;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.kientpham.webapp.commonlib.userserviceclient.dto.UserEditDTO;
import com.kientpham.webapp.commonlib.userserviceclient.dto.UserTableDTO;
import com.kientpham.webapp.userservice.user.UserReadService;
import com.kientpham.webapp.commonlib.userserviceclient.dto.GroupJoinListDTO;

import org.springframework.web.bind.annotation.ResponseBody;
import com.kientpham.webapp.commonlib.dto.paging.TablePage;
import com.kientpham.webapp.commonlib.dto.paging.PaginationCriteria;

@RestController
@RequestMapping(value="/userservice/users")
public class UserController{
	@Autowired
	private UserReadService userReadService;
	@Autowired
	private UserWriteService userWriteService;

	@RequestMapping(value="/usertabledto", method=RequestMethod.GET)
	public List<UserTableDTO> getUserTableDTO(){
		return userReadService.getListUserTableDTO();		
	}

	@RequestMapping(value="/groupjoinlistdto", method=RequestMethod.GET)
	public List<GroupJoinListDTO> getGroupJoinListDTO(@RequestParam Integer id){
		return userReadService.getGroupJoinListDTO(id);
	}
	@RequestMapping(value="usereditdto",method=RequestMethod.GET)
	public ResponseEntity<UserEditDTO> getusereditdto(@RequestParam Integer id){
		return new ResponseEntity<UserEditDTO>(userReadService.getUserEditDTOById(id),HttpStatus.OK);
	}

	@RequestMapping(value="/usereditdto", method=RequestMethod.POST)
	public String saveUser(@RequestBody(required=true) UserEditDTO userEditDTO) {
		userWriteService.saveUser(userEditDTO);
		return "Saved Successfully!";
	}

	@RequestMapping(method=RequestMethod.DELETE)
	public String deleteUser(@RequestBody(required=true) Integer id) {
		userWriteService.deleteUserById(id);
		return "Successfully";
	}

	@RequestMapping(value = "/tablepage", method = RequestMethod.POST)
	@ResponseBody
	public TablePage listUsers(@RequestBody PaginationCriteria paginationCriteria) {		
		return userReadService.getUsersListPaging(paginationCriteria);
	}

}