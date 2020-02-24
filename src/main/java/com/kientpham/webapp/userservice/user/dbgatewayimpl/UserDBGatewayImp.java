package com.kientpham.webapp.userservice.user.dbgatewayimpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kientpham.webapp.userservice.user.User;
import com.kientpham.webapp.userservice.user.dbgatewayimpl.UserRepository;
import com.kientpham.webapp.userservice.user.UserDBGateway;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import com.kientpham.webapp.userservice.user.dbgatewayimpl.UserRepositoryPaging;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.kientpham.webapp.commonlib.dto.paging.PagingInputDTO;
import com.kientpham.webapp.commonlib.dto.paging.PagingOutputDTO;

@Component
public class UserDBGatewayImp implements UserDBGateway{
	@Autowired
	private UserRepository repository;

	@Override
	public List<User> findAll() {
		return (List<User>) repository.findAll();
	}

	@Override
	public User findById(Integer id) {
		return repository.findById(id).orElse(new User());
	}

	@Override
	public List<User> findByListIds(List<Integer> listId) {		
		return (List<User>) repository.findAllById(listId);
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);		
	}

	@Override
	public User save(User entity) {
		return repository.save(entity);
	}
	@Autowired
	private UserRepositoryPaging pagingRepository;


	@Override
	public Page<User> findAll(Pageable pageRequest) {
		return pagingRepository.findAll(pageRequest);
	}

	@Override
	public PagingOutputDTO<User> search(PagingInputDTO pagingInput) {
		String searchTerm = pagingInput.getSearchTerm();
		String sortColumn = pagingInput.getSortedColumnName();
		Sort sort = (pagingInput.getOrder().equalsIgnoreCase("ASC")) ? Sort.by(sortColumn).ascending()
				: Sort.by(sortColumn).descending();
		Pageable pageRequest = PageRequest.of(pagingInput.getStart() / pagingInput.getLength(), pagingInput.getLength(),
				sort);
		Page<User> page;
		if (searchTerm.isEmpty()) {
			page = pagingRepository.findAll(pageRequest);
		} else {
			page = pagingRepository.searchUser(searchTerm, pageRequest);
		}
		PagingOutputDTO<User> pageOutput = new PagingOutputDTO<User>();
		pageOutput.setContent(page.getContent());
		pageOutput.setTotalElements((int) page.getTotalElements());

		return pageOutput;
	}


}