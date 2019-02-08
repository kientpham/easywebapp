package com.datatransforming.baseapp.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.datatransforming.baseapp.entity.Category;
import com.datatransforming.baseapp.repository.CategoryRepository;
import com.datatransforming.baseapp.service.CategoryService;
@Component
public class CategoryServiceImp implements CategoryService{

	@Autowired
	private CategoryRepository catRepo;
	
	@Override
	public List<Category> getAllCategory() {		
		List<Category> listCat=catRepo.findAll(Sort.by("order").ascending());		
		return listCat;
	}
	

}
