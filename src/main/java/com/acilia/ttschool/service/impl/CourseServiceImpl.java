package com.acilia.ttschool.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.acilia.ttschool.controller.CourseController;
import com.acilia.ttschool.entity.Course;
import com.acilia.ttschool.repository.CourseJpaRepository;
import com.acilia.ttschool.service.CourseService;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService {

	private static final Log LOGGER=LogFactory.getLog(CourseServiceImpl.class);
	
	
	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;
	
	
	@Override
	public List<Course> listAllCourse() {
		LOGGER.info("Call listAllCourse" );
		return courseJpaRepository.findAll();
	}

	@Override
	public Course addCourse(Course course) {
		return courseJpaRepository.save(course);
	}

	@Override
	public int removeCourse(int id) {
		// TODO Auto-generated method stub
		courseJpaRepository.delete(id);
		return 0;
	}

	@Override
	public Course updateCourse(Course course) {
		//revisa el id si se le pasa y comprueba si existe en bbdd y lo modifica
		return courseJpaRepository.save(course);
	}

	@Override
	public Course getCourse(int id) {
		return courseJpaRepository.findOne(id);
	}

}
