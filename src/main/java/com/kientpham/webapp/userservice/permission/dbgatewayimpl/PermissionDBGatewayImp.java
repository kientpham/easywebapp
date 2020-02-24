package com.kientpham.webapp.userservice.permission.dbgatewayimpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kientpham.webapp.userservice.permission.Permission;
import com.kientpham.webapp.userservice.permission.dbgatewayimpl.PermissionRepository;
import com.kientpham.webapp.userservice.permission.PermissionDBGateway;

@Component
public class PermissionDBGatewayImp implements PermissionDBGateway{
	@Autowired
	private PermissionRepository repository;

	@Override
	public List<Permission> findAll() {
		return (List<Permission>) repository.findAll();
	}

	@Override
	public Permission findById(Integer id) {
		return repository.findById(id).orElse(new Permission());
	}

	@Override
	public List<Permission> findByListIds(List<Integer> listId) {		
		return (List<Permission>) repository.findAllById(listId);
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);		
	}

	@Override
	public Permission save(Permission entity) {
		return repository.save(entity);
	}

}