package com.kienp.webapp.userservice.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kienp.webapp.userservice.entity.Category;
@Component
public interface CategoryService {
	
	public List<Category> getAllCategory();
	
	public List<Category> getCategoryByGroup(String categoryGroup);
	
	public List<Category> getCategoryByGroups(List<String> categoryGroups);

}
