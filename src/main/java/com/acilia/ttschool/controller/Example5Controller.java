package com.acilia.ttschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("example5")
public class Example5Controller {
	
	public static final String EXAMPLE_VIEW="example5";
	
	// recibimos un parámetro
	//http://localhost:8080/example5/request1?nm=Alicia
	//Para que no sea obligatorio required=false, ya que por defecto required=true
	
	//http://localhost:8080/example5/request1
	//http://localhost:8080/example5/request1?nm=
	//Para añadir un valor por defecito... defaultValue="NULL" por si el parámetro no se indica o viene vacío
	@GetMapping("/request1")
	public ModelAndView request1(@RequestParam(name="nm",required=false,defaultValue="NULL") String name){
		ModelAndView model = new ModelAndView(EXAMPLE_VIEW);
		model.addObject("nm_in_model", name);
		return model; 
		
	}
	//También podemos incluir parámetros en la petición directamente en el path como esto
	//http://localhost:8080/example5/request2/ALI
	//Esto se captura con @PathVariable
	
	@GetMapping("/request2/{nm}")
	public ModelAndView request2(@PathVariable("nm") String nombre){
		ModelAndView model =new ModelAndView(EXAMPLE_VIEW);
		model.addObject("nm_in_model", nombre);
		return model;
		
	}

}
