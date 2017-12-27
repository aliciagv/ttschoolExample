package com.acilia.ttschool.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.acilia.ttschool.model.Persona;

@Controller
@RequestMapping("example6")

public class Example6Controller {
	
	private static final Log LOGGER= LogFactory.getLog(Example6Controller.class);

	public static final String FORM_VIEW="form";
	public static final String RESULT_VIEW="result";

	//http://localhost:8080/example6/showForm
	@GetMapping("/showForm")
	public String showForm(Model model){
		LOGGER.info("INFO TRACE");
		LOGGER.warn("WARNING TRACE");
		LOGGER.error("ERROR TRACE");
		LOGGER.debug("DEBUG TRACE");
		model.addAttribute("persona", new Persona());
		return FORM_VIEW;
		
	}
	// INICIO Redirección 
	//http://localhost:8080/example6 -> http://localhost:8080/example6/showForm
	// FORMA 1
	
	/*@GetMapping("/")
	public String redirect(){
		return "redirect:/example6/showForm";
		
	}*/
	
	// FORMA 2
	@GetMapping("/")
	public RedirectView redirect(){
		return new RedirectView("/example6/showForm");
	}
	
	//FIN REDIRECCION
	
	//Se capturan los datos del formulario
	@PostMapping("/addperson")
	public ModelAndView addPerson(@Valid @ModelAttribute("persona") Persona persona,BindingResult bindingResult){
		LOGGER.info("METHOD: 'addPerson' -- PARAMS:'" + persona+ "'");
		ModelAndView model =new ModelAndView();
		if (bindingResult.hasErrors()){
			model.setViewName(FORM_VIEW);
		} else {
			model.setViewName(RESULT_VIEW);
			model.addObject("persona",persona);
			
		}
		LOGGER.info("TEMPLATE: '" + RESULT_VIEW + "'--DATA '" + persona + "'");
		return model;
	}
}
