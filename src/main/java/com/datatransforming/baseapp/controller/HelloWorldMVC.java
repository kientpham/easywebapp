package com.datatransforming.baseapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.datatransforming.baseapp.repository.GroupRepository;
import com.datatransforming.baseapp.entity.*;

import lombok.Getter;
import lombok.Setter;

@Controller
@Getter
@Setter
public class HelloWorldMVC {

	private String hello;

	@Autowired
	private GroupRepository groupRepository;

	@GetMapping("/hello")
	public String index(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {
		List<Group> group = groupRepository.findByName("Admin");
		
		//Optional<Group> mgroup = groupRepository.findById(1L);
		//Group group = groupRepository.findById(1L).ifPresent(arg0);;
//		String nameGroup="";
//		for (Group group: groupRepository.findAll()) {
//			nameGroup+=", " + group.getName();
//		}
		
		//String groupName = mgroup.get().getName();//group.get(0).getDescription();
		String groupName = group.get(0).getDescription();
		model.addAttribute("name", groupName);
		return "hello";
	}

	@GetMapping("/user")
	public String getUser(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "index1";
	}
}
