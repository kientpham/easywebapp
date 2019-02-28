package com.kienp.webapp.userservice.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.kienp.webapp.userservice.dbgateway.repository.CategoryRepository;
import com.kienp.webapp.userservice.entity.Category;
import com.kienp.webapp.userservice.service.CategoryService;

@Component
public class CategoryDomain {

	@Autowired
	private CategoryRepository catRepo;
	
	
	public List<Category> getAllCategory() {		
		List<Category> listCat=catRepo.findAll(Sort.by("order").ascending());		
		return listCat;
	}

	
	public List<Category> getCategoryByGroup(String categoryGroup) {
		return catRepo.findByCategoryGroup(categoryGroup);
	}	

	
	public List<Category> getCategoryByGroups(List<String> categoryGroups) {
		List<Category> categoryList=new ArrayList<Category>();				
		for(String catGroup: categoryGroups) {
			categoryList.addAll(this.getCategoryByGroup(catGroup));	
		}
		return categoryList;
	}

	
	public Map<Integer, String> getCategoryMapByGroups(List<String> categoryGroups) {
		Map<Integer, String> map=new HashMap<Integer, String>();
		for(String catGroup: categoryGroups) {
			for(Category cat:this.getCategoryByGroup(catGroup)) {
				map.put(cat.getId(), cat.getValue());
			}	
		}
		return map;
	}	

}
