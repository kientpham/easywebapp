package com.kientpham.webapp.userservice.user;
import java.util.Set;
import java.util.ArrayList;
import com.kientpham.webapp.commonlib.userserviceclient.dto.UserJoinListDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kientpham.webapp.userservice.user.User;
import com.kientpham.webapp.userservice.user.UserDBGateway;
import com.kientpham.webapp.commonlib.userserviceclient.dto.UserEditDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.kientpham.webapp.commonlib.dto.paging.PagingInputDTO;
import com.kientpham.webapp.commonlib.dto.paging.PagingOutputDTO;

@Component
public class UserDomain{
	@Autowired
	private UserDBGateway dbGateway;
	

	public List<UserJoinListDTO> getUserJoinListDTO(Set<Integer> ids) {
		List<UserJoinListDTO> returnList=new ArrayList<UserJoinListDTO>(); 
		List<User> allUser=this.findAll(); 
		for (User user: allUser) {
			UserJoinListDTO userJoin=new UserJoinListDTO();
			userJoin.setId(user.getId());
			userJoin.setUsername(user.getUsername());
			userJoin.setFirstName(user.getFirstName());
			userJoin.setLastName(user.getLastName());
			userJoin.setEmail(user.getEmail());
			if (ids!=null && ids.contains(user.getId())) {
				userJoin.setIsChecked("checked");
			}
			returnList.add(userJoin);
		} 
 		return returnList;
	}

	public List<User> findAll(){
		return dbGateway.findAll();
	}
	
	public List<User> findByListIds(List<Integer> ids){
		return dbGateway.findByListIds(ids);
	}
	
	public User findById(Integer id) {
		if (id==null) return null;
		return dbGateway.findById(id);
	}

	public void deleteById(Integer id) {
		dbGateway.deleteById(id);
	}
	
	public User save(User entity) {
		return dbGateway.save(entity);
	}

	public User getUserEntity(UserEditDTO userEditDTO) {
		User user=new User();
		user.setId(userEditDTO.getId());
		user.setUsername(userEditDTO.getUsername());
		user.setPassword(userEditDTO.getPassword());
		user.setFirstName(userEditDTO.getFirstName());
		user.setLastName(userEditDTO.getLastName());
		user.setEmail(userEditDTO.getEmail());
		user.setUserType(userEditDTO.getUserType());
		user.setStatus(userEditDTO.getStatus());
		user.setAddress(userEditDTO.getAddress());
		return user;
	}

	public Page<User> getAllPaging(Pageable pageRequest){
		return dbGateway.findAll(pageRequest);
	}	

	public PagingOutputDTO<User> searchPaging(PagingInputDTO pagingInput) {
		
		return dbGateway.search(pagingInput);
	}
}