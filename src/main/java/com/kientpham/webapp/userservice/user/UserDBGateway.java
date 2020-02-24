package com.kientpham.webapp.userservice.user;
import java.util.List;
import com.kientpham.webapp.userservice.user.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.kientpham.webapp.commonlib.dto.paging.PagingInputDTO;
import com.kientpham.webapp.commonlib.dto.paging.PagingOutputDTO;

public interface UserDBGateway{
	public List<User> findAll();

	public User findById(Integer id);

	public List<User> findByListIds(List<Integer> listId);

	public void deleteById(Integer id);

	public User save(User entity);

	public Page<User> findAll(Pageable pageRequest);

	public PagingOutputDTO<User> search(PagingInputDTO pagingInput);
}