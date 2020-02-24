package com.kientpham.webapp.userservice.user;
import com.kientpham.webapp.commonlib.userserviceclient.dto.GroupJoinListDTO;
import java.util.List;
import com.kientpham.webapp.userservice.user.User;
import com.kientpham.webapp.commonlib.userserviceclient.dto.UserTableDTO;
import com.kientpham.webapp.commonlib.userserviceclient.dto.UserEditDTO;
import java.util.UUID;


import com.kientpham.webapp.commonlib.dto.paging.TablePage;
import com.kientpham.webapp.commonlib.dto.paging.PaginationCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.kientpham.webapp.commonlib.dto.paging.PagingInputDTO;
import com.kientpham.webapp.commonlib.dto.paging.PagingOutputDTO;

public interface UserReadService{

	public List<GroupJoinListDTO> getGroupJoinListDTO(UUID userId);

	public UserEditDTO getUserEditDTOById(UUID id);

	public List<UserTableDTO> getListUserTableDTO();
	public List<String> getListFeature(UUID userId);

	public PagingOutputDTO<User> searchUser(PagingInputDTO pagingInput);
	
	public Page<User> getAllUser(Pageable pageRequest);

	public TablePage getUsersListPaging(PaginationCriteria paginationCriteria);

}