package com.kientpham.webapp.userservice.user;
import java.util.List;
import com.kientpham.webapp.userservice.user.User;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.kientpham.webapp.commonlib.dto.paging.PagingInputDTO;
import com.kientpham.webapp.commonlib.dto.paging.PagingOutputDTO;

public interface UserDBGateway{
	public List<User> findAll();

	public User findById(UUID id);

	public List<User> findByListIds(List<UUID> listId);

	public void deleteById(UUID id);

	public User save(User entity);

	public Page<User> findAll(Pageable pageRequest);

	public PagingOutputDTO<User> search(PagingInputDTO pagingInput);
}