package com.kientpham.webapp.userservice.group;
import java.util.List;
import com.kientpham.webapp.userservice.group.Group;

public interface GroupDBGateway{
	public List<Group> findAll();

	public Group findById(Integer id);

	public List<Group> findByListIds(List<Integer> listId);

	public void deleteById(Integer id);

	public Group save(Group entity);


}