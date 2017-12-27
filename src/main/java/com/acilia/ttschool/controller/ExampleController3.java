package com.acilia.ttschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.acilia.ttschool.model.Persona;

@Controller
@RequestMapping("example3")
public class ExampleController3 {

	public static final String EXAMPLE_VIEW = "example3";

	// http://localhost:8080/example3/exampleMAV3
	@GetMapping(value = "exampleMAV3")
	public ModelAndView exampleMAV(Model model) {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("persona", new Persona("Alejandro",7));
		return mav;
	}

	// http://localhost:8080/example3/exampleString3
	@GetMapping("/exampleString3")
	public String exampleString2(Model model) {
		model.addAttribute("persona", new Persona("Alicia",35));
		return EXAMPLE_VIEW;
	}

}
