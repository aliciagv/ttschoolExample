package com.acilia.ttschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


// http://localhost:8080/say/helloworld -> helloworld.html

@Controller
@RequestMapping("/say")
public class HelloWorldController {

	@GetMapping("/helloworld")
	public String helloWorld(){
		return "helloworld";
		
	}
}
