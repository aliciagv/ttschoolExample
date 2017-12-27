package com.acilia.ttschool.converter;

import org.springframework.stereotype.Component;

import com.acilia.ttschool.entity.Course;
import com.acilia.ttschool.model.CourseModel;

@Component("courseConverter")
public class CourseConverter {
	
	//Entity --> Model
	public CourseModel entitytoModel(Course course) {
		CourseModel coursemodel=new CourseModel();
		coursemodel.setName(course.getName());
		coursemodel.setDescription(course.getDescription());
		coursemodel.setPrice(course.getPrice());
		coursemodel.setHours(course.getHours());
		return coursemodel;
		
		
	}
	
	//Model --> Entity
	
	public Course modelToEntity(CourseModel coursemodel){
		Course course = new Course();
		course.setName(coursemodel.getName());
		course.setDescription(coursemodel.getDescription());
		course.setHours(coursemodel.getHours());
		course.setPrice(coursemodel.getPrice());
		return course;
		
	}
	

}
