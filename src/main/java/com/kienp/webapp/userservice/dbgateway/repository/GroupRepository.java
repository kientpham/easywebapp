package com.kienp.webapp.userservice.dbgateway.repository;

import com.kienp.webapp.userservice.entity.Group;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface GroupRepository extends CrudRepository<Group, Integer> {

	List<Group> findByIdIn(List<Integer> list);
	
	List<Group> findByName(String name);
	
//	@Query("SELECT g.id, g.name, \r\n" + 
//			"CASE WHEN (select u.id from USER_GROUP_JOIN as u where g.id=u.groupId and u.id= :id) is null \r\n" + 
//			"THEN 0 Else 1 end as isUserIn \r\n" + 
//			"FROM Group g")
//	public List<Group> getGroupListJoinUser(@Param("id") Integer userId);
	
//	@Query("Select g FROM Group g where g.id= :id")
//	public List<Group> getGroupListJoinUser(@Param("id") Integer userId);

}
