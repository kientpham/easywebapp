package com.datatransforming.baseapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UrlController {

	@GetMapping("/index")
	public String userList() {
		
		return "index";
	}
}
