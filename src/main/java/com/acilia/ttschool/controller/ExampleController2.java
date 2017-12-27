package com.acilia.ttschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("example2")
public class ExampleController2 {

	public static final String EXAMPLE_VIEW = "example2";

	// http://localhost:8080/example2/exampleMAV2
	@GetMapping(value = "exampleMAV")
	public ModelAndView exampleMAV(Model model) {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("name","Alejandro");
		return mav;
	}

	// http://localhost:8080/example2/exampleString2
	@GetMapping("/exampleString2")
	public String exampleString2(Model model) {
		model.addAttribute("name", "Alicia");
		return EXAMPLE_VIEW;
	}

}
