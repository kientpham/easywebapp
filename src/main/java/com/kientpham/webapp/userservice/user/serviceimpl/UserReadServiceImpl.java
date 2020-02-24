package com.kientpham.webapp.userservice.user.serviceimpl;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.UUID;

import com.kientpham.webapp.userservice.user.User;
import com.kientpham.webapp.userservice.user.UserDomain;
import com.kientpham.webapp.userservice.user.UserReadService;
import com.kientpham.webapp.commonlib.userserviceclient.dto.UserEditDTO;
import java.util.stream.Collectors;import com.kientpham.webapp.userservice.group.Group;
import com.kientpham.webapp.userservice.group.GroupReadService;
import com.kientpham.webapp.commonlib.userserviceclient.dto.GroupJoinListDTO;
import com.kientpham.webapp.userservice.group.GroupDomain;
import com.kientpham.webapp.commonlib.userserviceclient.dto.UserTableDTO;
import com.kientpham.webapp.shareservice.lookup.LookupReadService;
import com.kientpham.webapp.userservice.permission.Permission;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;

import java.util.HashMap;
import com.kientpham.webapp.commonlib.dto.paging.TablePage;
import com.kientpham.webapp.commonlib.utils.DataTablePresenter;
import com.kientpham.webapp.commonlib.dto.paging.PaginationCriteria;
import com.kientpham.webapp.commonlib.dto.paging.PagingInputDTO;
import com.kientpham.webapp.commonlib.dto.paging.PagingOutputDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.kientpham.webapp.commonlib.dto.paging.PagingInputDTO;
import com.kientpham.webapp.commonlib.dto.paging.PagingOutputDTO;

@Component
public class UserReadServiceImpl implements UserReadService{

	@Autowired
	private UserDomain userDomain;

	@Override
	public UserEditDTO getUserEditDTOById(UUID id) {
		return new UserEditDTO(userDomain.findById(id));
	}

	@Autowired
	private LookupReadService lookupReadService;

	@Override
	public List<UserTableDTO> getListUserTableDTO() {
		Map<Integer, String> lookupMap = lookupReadService.getMapAllLookup();
		List<User> allUser = userDomain.findAll();
		List<UserTableDTO> userTable = new ArrayList<UserTableDTO>();
		for (User user :allUser) {
 			userTable.add(new UserTableDTO(user, lookupMap));
		}
		return userTable;
	}

	@Autowired
	private GroupDomain groupDomain;

	@Override
	public List<GroupJoinListDTO> getGroupJoinListDTO(UUID userId) {
		if (userId !=null) {
			return groupDomain.getGroupJoinListDTO(userDomain.findById(userId).getGroups().stream().map(Group::getId).collect(Collectors.toSet()));
		}
		return groupDomain.getGroupJoinListDTO(null);
	}
@Override
	public List<String> getListFeature(UUID userId) {
		User user = userDomain.findById(userId);
		List<Group> groupList = user.getGroups();
		List<Permission> permissionList = new ArrayList<Permission>();
		for (Group group : groupList) {
			permissionList.addAll(group.getPermissions());
		}
		Set<String> featureList = new HashSet<String>();
		for (Permission permission : permissionList) {
			String menuPath=permission.getMenuPath();
			if (permission.getToggle() && menuPath!=null && !menuPath.isEmpty()) {
				featureList.addAll(Arrays.asList(permission.getMenuPath().trim().split("\\\\")));
			}
		}
		return new ArrayList<String>(featureList);
	}
	@Override
	public Page<User> getAllUser(Pageable pageRequest) {
		return userDomain.getAllPaging(pageRequest);
	}
	@Override
	public PagingOutputDTO<User> searchUser(PagingInputDTO pagingInput) {
		return userDomain.searchPaging(pagingInput);
	}
	Map<Integer, String> columnMap = new HashMap<Integer, String>() {
		private static final long serialVersionUID = 1L;
		{
			put(1, "id");
			put(2, "username");
			put(3, "password");
			put(4, "firstName");
			put(5, "lastName");
			put(6, "birthDate");
			put(7, "email");
			put(8, "userType");
			put(9, "status");
			put(10, "address");
			put(11, "lastUpdated");
			put(12, "created");
		}
	};

	public TablePage getUsersListPaging(PaginationCriteria paginationCriteria) {

		PagingInputDTO pagingInput = new PagingInputDTO();
		pagingInput.setStart(paginationCriteria.getStart());
		pagingInput.setLength(paginationCriteria.getLength());
		pagingInput.setSearchTerm(paginationCriteria.getSearch().getValue());
		pagingInput.setSortedColumnName(columnMap.get(paginationCriteria.getOrder().get(0).getColumn()));
		pagingInput.setOrder(paginationCriteria.getOrder().get(0).getDir());

		PagingOutputDTO<User> pagingOutput = userDomain.searchPaging(pagingInput);

		List<UserTableDTO> listUserTable = this.convertListUserToDataTable(pagingOutput.getContent(),
				lookupReadService.getMapAllLookup());

		return DataTablePresenter.buildTablePage(listUserTable, paginationCriteria.getDraw(),
				(int) pagingOutput.getTotalElements());
	}
	private List<UserTableDTO> convertListUserToDataTable(List<User> userList, Map<Integer, String> categoryMap) {
		List<UserTableDTO> list = new ArrayList<UserTableDTO>();
		for (User user : userList) {
			list.add(new UserTableDTO(user, categoryMap));
		}
		return list;
	}
}