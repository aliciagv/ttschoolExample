package com.acilia.ttschool.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {
	
	public static final String ISE_VIEW="error/500";
	
	@ExceptionHandler(Exception.class)
	public String showInternaServerError(){
	 return ISE_VIEW;	
		
	}

}
