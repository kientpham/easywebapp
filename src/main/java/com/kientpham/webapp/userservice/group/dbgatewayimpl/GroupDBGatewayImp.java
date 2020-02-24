package com.kientpham.webapp.userservice.group.dbgatewayimpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kientpham.webapp.userservice.group.Group;
import com.kientpham.webapp.userservice.group.dbgatewayimpl.GroupRepository;
import com.kientpham.webapp.userservice.group.GroupDBGateway;

@Component
public class GroupDBGatewayImp implements GroupDBGateway{
	@Autowired
	private GroupRepository repository;

	@Override
	public List<Group> findAll() {
		return (List<Group>) repository.findAll();
	}

	@Override
	public Group findById(Integer id) {
		return repository.findById(id).orElse(new Group());
	}

	@Override
	public List<Group> findByListIds(List<Integer> listId) {		
		return (List<Group>) repository.findAllById(listId);
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);		
	}

	@Override
	public Group save(Group entity) {
		return repository.save(entity);
	}

}