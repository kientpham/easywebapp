package com.kienp.webapp.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kienp.webapp.userservice.dto.entity.Category;
import com.kienp.webapp.userservice.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService catService;
	
	@GetMapping("/getAllCategories")
	public List<Category> getCategoryList(){	
		List<Category> listCat=catService.getAllCategory();
		return listCat;
	}
}
