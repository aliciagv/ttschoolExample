package com.acilia.ttschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.acilia.ttschool.component.ExampleComponent;

@Controller
@RequestMapping("example")
public class ExampleController {

	public static final String EXAMPLE_VIEW = "example";
	// Inyectar un componente que se encuentra en su memoria @Autowired
	// con Qualifier
	@Autowired
	@Qualifier("exampleComponent")
	private ExampleComponent exampleComponent;

	// http://localhost:8080/example/exampleString
	@RequestMapping(value = "exampleString", method = RequestMethod.GET)
	public String exampleString() {
		exampleComponent.sayHello();
		return EXAMPLE_VIEW;
	}

	// http://localhost:8080/example/exampleMAV
	@RequestMapping(value = "exampleMAV", method = RequestMethod.GET)
	public ModelAndView exampleMAV() {
		return new ModelAndView(EXAMPLE_VIEW);
	}

	// http://localhost:8080/example/exampleString2
	@GetMapping("/exampleString2")
	public String exampleString2() {
		return EXAMPLE_VIEW;
	}

}
