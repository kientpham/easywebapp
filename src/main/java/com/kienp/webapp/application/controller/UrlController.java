package com.kienp.webapp.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UrlController {

	@GetMapping("/userleftmenu")
	public String userLeftMenu() {
		
		return "user_left_menu";
	}
	
	@GetMapping("/usertopmenu")
	public String userTopMenu() {		
		return "user_top_menu";
	}
	
	@GetMapping("/test")
	public String test() {		
		return "index1";
	}
	
	
	
}
