package com.acilia.ttschool.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.acilia.ttschool.entity.Course;
import com.acilia.ttschool.service.CourseService;

@Controller
@RequestMapping("courses")
public class CourseController {
	
	
	private static final Log LOGGER=LogFactory.getLog(CourseController.class);
	
	private static final String COURSE_VIEW="courses";
	private static final String EDITFORM_VIEW="editcourses";
	
	@Autowired
	@Qualifier("courseServiceImpl")
	private CourseService courseService;
	
	@GetMapping("listAllCourses")
	public ModelAndView listAllCourses(){
		LOGGER.info("CALL listAllCourses" );
		ModelAndView model =new ModelAndView(COURSE_VIEW);
		model.addObject("courses", courseService.listAllCourse());
		model.addObject("course", new Course());
		return model;
		
		
	}
	
	@PostMapping("/addcourse")
	public String addCourse(@ModelAttribute("course") Course course){
		
		LOGGER.info("CALL addCourse() --Param: " + course.toString());
		courseService.addCourse(course);
		return "redirect:/courses/listAllCourses";
		
	}
	
	@GetMapping("/editcourse/{id}")
	public ModelAndView editcourse(@PathVariable int id){
		
		LOGGER.info("CALL editcourse() --Param: " + id);
		ModelAndView model =new ModelAndView(EDITFORM_VIEW);
		model.addObject("course", courseService.getCourse(id));
		return model;
		
	}
	
	@PostMapping("/editcourse")
	public String editCourse(@ModelAttribute("course") Course course){
		
		LOGGER.info("CALL editCourse() --Param: " + course.toString());
		courseService.updateCourse(course);
		return "redirect:/courses/listAllCourses";
		
	}
	
	
	@GetMapping("/deletecourse/{id}")
	public String deleteCourse(@PathVariable int id){
		
		LOGGER.info("CALL deleteCourse() --Param: " + id);
		courseService.removeCourse(id);
		return "redirect:/courses/listAllCourses";
		
	}
	

}
