package com.kienp.webapp.userservice.dbgateway.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import com.kienp.webapp.userservice.dto.entity.Category;


public interface CategoryRepository extends CrudRepository<Category, Integer> {

	List<Category> findByCategoryGroup(String categoryGroup);
	
//	@Override
	List<Category> findAll(Sort sort);


}
