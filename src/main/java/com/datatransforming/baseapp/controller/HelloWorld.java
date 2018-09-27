package com.datatransforming.baseapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datatransforming.baseapp.services.model.request.SampleRequest;

@RestController
public class HelloWorld {

	 @RequestMapping("/")
	    public String index() {
		 	if (new SampleRequest("Hello my workflow").processRequest()!=null)
		 		return "Successfully process the request";
		 	else 
		 		return "Unsuccesfully process the request";		 	
	    }
}
