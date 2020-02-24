package com.kientpham.webapp.userservice.user.serviceimpl;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Map;

import com.kientpham.webapp.userservice.user.User;
import com.kientpham.webapp.userservice.user.UserDomain;
import com.kientpham.webapp.userservice.user.UserWriteService;
import com.kientpham.webapp.commonlib.userserviceclient.dto.UserEditDTO;
import com.kientpham.webapp.userservice.group.Group;
import com.kientpham.webapp.userservice.group.GroupDomain;
import com.kientpham.webapp.commonlib.userserviceclient.dto.GroupJoinListDTO;
import com.kientpham.webapp.commonlib.userserviceclient.dto.UserTableDTO;
import com.kientpham.webapp.shareservice.lookup.LookupReadService;


@Component
public class UserWriteServiceImpl implements UserWriteService{

	@Autowired
	private UserDomain userDomain;

	@Autowired
	private LookupReadService lookupReadService;

	@Autowired
	private GroupDomain groupDomain;

	@Override
	public void deleteUserById(Integer id) {
		userDomain.deleteById(id);		
	}

	@Override
	public void deleteListUser(List<Integer> ids) {
		for (Integer id:ids) {
			userDomain.deleteById(id);
		}		
	}

	@Override
	public UserEditDTO saveUser(UserEditDTO userEditDTO) {
		User user=userDomain.getUserEntity(userEditDTO);
		user.setGroups(groupDomain.findByListIds(userEditDTO.getGroups()));
;		userDomain.save(user);
		return userEditDTO;
	}
}