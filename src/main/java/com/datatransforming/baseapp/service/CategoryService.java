package com.datatransforming.baseapp.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.datatransforming.baseapp.entity.Category;
@Component
public interface CategoryService {
	
	public List<Category> getAllCategory();

}
