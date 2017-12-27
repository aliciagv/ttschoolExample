package com.acilia.ttschool.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acilia.ttschool.entity.Course;

@Repository("courseJpaRepository")
public interface CourseJpaRepository extends JpaRepository<Course,Serializable>{

	// consulta automática que lo hace por precio
	public abstract Course findByPrice(int price);
	
	//consulta automática por precio y name sin implementar nada
	public abstract Course findByPriceAndName(int price,String name);
	
	// busqueda por nombre y ordenado por horas
	public abstract List<Course> findByNameOrderByHours(String name);
	
	
	public abstract Course findByNameOrPrice(String name, int price);
	
	
	
	
}
