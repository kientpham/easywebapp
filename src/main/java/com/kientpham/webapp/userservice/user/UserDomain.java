package com.kientpham.webapp.userservice.user;
import java.util.Set;
import java.util.ArrayList;
import com.kientpham.webapp.commonlib.userserviceclient.dto.UserJoinListDTO;
import com.kientpham.webapp.commonlib.utils.DateStringUtils;
import java.util.UUID;
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
	

	public List<UserJoinListDTO> getUserJoinListDTO(Set<UUID> ids) {
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
	
	public List<User> findByListIds(List<UUID> ids){
		return dbGateway.findByListIds(ids);
	}
	
	public User findById(UUID id) {
		if (id==null) return null;
		return dbGateway.findById(id);
	}

	public void deleteById(UUID id) {
		dbGateway.deleteById(id);
	}
	
	public User save(User entity) {
		return dbGateway.save(entity);
	}

	public User getUserEntity(UserEditDTO userEditDTO) {
		User user=new User();
		if (userEditDTO.getId()==null) {
						userEditDTO.setCreated(DateStringUtils.getCurentTimeUTC());
		}
		user.setId(userEditDTO.getId());
		user.setUsername(userEditDTO.getUsername());
		user.setPassword(userEditDTO.getPassword());
		user.setFirstName(userEditDTO.getFirstName());
		user.setLastName(userEditDTO.getLastName());
		user.setBirthDate(userEditDTO.getBirthDate());
		user.setEmail(userEditDTO.getEmail());
		user.setUserType(userEditDTO.getUserType());
		user.setStatus(userEditDTO.getStatus());
		user.setAddress(userEditDTO.getAddress());
		user.setLastUpdated(DateStringUtils.getCurentTimeUTC());
		user.setCreated(userEditDTO.getCreated());
		return user;
	}

	public Page<User> getAllPaging(Pageable pageRequest){
		return dbGateway.findAll(pageRequest);
	}	

	public PagingOutputDTO<User> searchPaging(PagingInputDTO pagingInput) {
		
		return dbGateway.search(pagingInput);
	}
}