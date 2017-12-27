package com.acilia.ttschool.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.acilia.ttschool.model.Persona;
import com.acilia.ttschool.service.ExampleService;

@Controller
@RequestMapping("example4")
public class ExampleController4 {

	public static final String EXAMPLE_VIEW = "example4";

	@Autowired 
	@Qualifier("exampleService")
	private ExampleService exampleService;
	
	
	// http://localhost:8080/example4/exampleMAV4
	@GetMapping(value = "exampleMAV4")
	public ModelAndView exampleMAV(Model model) {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("personas", listPersonas());
		return mav;
	}

	// http://localhost:8080/example4/exampleString4
	@GetMapping("/exampleString4")
	public String exampleString2(Model model) {
		model.addAttribute("personas", listPersonas());
		return EXAMPLE_VIEW;
	}
	
	
	// http://localhost:8080/example4/exampleMAVService4
	@GetMapping(value = "exampleMAVService4")
	public ModelAndView exampleMAVService(Model model) {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("personas", exampleService.getListPeople());
		return mav;
	}

	// http://localhost:8080/example4/exampleStringService4
	@GetMapping("/exampleStringService4")
	public String exampleStringService(Model model) {
		model.addAttribute("personas", exampleService.getListPeople());
		return EXAMPLE_VIEW;
	}
	
	private List<Persona> listPersonas(){
		List<Persona> personas = new ArrayList<Persona>();
		personas.add(new Persona("Alicia",35));
		personas.add(new Persona("Alejandro",7));
		return personas;
	}

}
