package com.acilia.ttschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("example7")
public class Example7Controller {
	
	public static final String E404_VIEW="404";
	public static final String E500_VIEW="500";
	
	@GetMapping("/404")
	public String show404(){
		return E404_VIEW;
	}

	@GetMapping("/500")
	public String show500(){
		return E500_VIEW;
	}
}
