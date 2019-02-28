package com.kienp.webapp.userservice.service;

import java.util.List;
import java.util.Map;

import com.kienp.webapp.userservice.dto.entity.Category;

public interface CategoryService {
	
	public List<Category> getAllCategory();
	
	public List<Category> getCategoryByGroup(String categoryGroup);
	
	public List<Category> getCategoryByGroups(List<String> categoryGroups);
	
	public Map<Integer, String> getMapAllCategory();

}
