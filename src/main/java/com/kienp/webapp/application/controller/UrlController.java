package com.kienp.webapp.application.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kienp.webapp.application.presenter.layout.LayoutPresenter;

@Controller
public class UrlController {

	@Autowired
	@Qualifier("MenuLayoutPresenter")
	private LayoutPresenter layoutPresenter;
	
	@Value("${application.ui.layout}")
	private String indexPage;
	
	@GetMapping("/easyapp")
	public String getIndexPage() {		
		return indexPage;
	}
	
	@GetMapping("/easyapptopmenu")
	public String getIndexTopMenu() {		
		return "index_top_menu";
	}
	
	@GetMapping("/easyappleftmenu")
	public String getIndexLeftMenu() {		
		return "index_left_menu";
	}
	
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
	
	@GetMapping("/grouplist")
	public String groupList() {		
		return "group_list";
	}
	
	@GetMapping("/permissionlist")
	public String permissionList() {		
		return "permission_list";
	}
	
	@RequestMapping(value = "/buildLayout", method = RequestMethod.GET)
	public ResponseEntity<String> buildLayout(){
		return new ResponseEntity<String>(layoutPresenter.buildLayoutHTML(),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/buildMenu", method = RequestMethod.GET)
	public ResponseEntity<List<String>> buildMenu(){
		//List<String> listMenu=Arrays.asList("menuAdmin","menuManagePermission","menuManageGroup");
		return new ResponseEntity<List<String>>(layoutPresenter.getListFeatures(),HttpStatus.OK);
	}
	
}
