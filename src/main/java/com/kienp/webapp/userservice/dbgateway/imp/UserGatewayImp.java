package com.kienp.webapp.userservice.dbgateway.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.kienp.webapp.userservice.dbgateway.UserGatewayService;
import com.kienp.webapp.userservice.dbgateway.repository.UserPagingRepository;
import com.kienp.webapp.userservice.dbgateway.repository.UserRepository;
import com.kienp.webapp.userservice.dto.entity.User;
import com.kienp.webapp.userservice.dto.input.PagingInputDTO;
import com.kienp.webapp.userservice.dto.output.PagingOutputDTO;

@Component
public class UserGatewayImp implements UserGatewayService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserPagingRepository userPagingRepository;

	@Override
	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User findById(Integer userId) {
		return userRepository.findById(userId).orElse(new User());
	}

	@Override
	public List<User> deleteListUser(List<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUserById(Integer userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public Page<User> findAll(Pageable pageRequest) {
		return userPagingRepository.findAll(pageRequest);
	}

	@Override
	public PagingOutputDTO<User> searchUser(PagingInputDTO pagingInput) {
		String searchTerm = pagingInput.getSearchTerm();
		String sortColumn = pagingInput.getSortedColumnName();
		Sort sort = (pagingInput.getOrder().equalsIgnoreCase("ASC")) ? Sort.by(sortColumn).ascending()
				: Sort.by(sortColumn).descending();
		Pageable pageRequest = PageRequest.of(pagingInput.getStart() / pagingInput.getLength(), pagingInput.getLength(),
				sort);
		Page<User> page;
		if (searchTerm.isEmpty()) {
			page = userPagingRepository.findAll(pageRequest);
		} else {
			page = userPagingRepository.searchUser(searchTerm, pageRequest);
		}
		PagingOutputDTO<User> pageOutput = new PagingOutputDTO<User>();
		pageOutput.setContent(page.getContent());
		pageOutput.setTotalElements((int) page.getTotalElements());

		return pageOutput;
	}

}
