package com.acilia.ttschool.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.acilia.ttschool.entity.QCourse;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.acilia.ttschool.entity.Course;

@Repository("queryDSLExampleRepo")
public class QueryDSLExampleRepo {
	
	// declaramos los objetos querydsl generados
	private QCourse qcourse = QCourse.course;
	
	@PersistenceContext
	private EntityManager em;
	
	public void find(boolean exits){
		//JPAQuery para hacer consultas, em es el entitymanager, se encarga
		//de la persistencia de la aplicación
		JPAQuery<Course> query = new JPAQuery<Course>(em);
		//select de todas las columnas de tabla course where id=1
		Course course1 =query.select(qcourse).from(qcourse).where(qcourse.id.eq(1)).fetchOne();
		//select nombre y descripción de tabla course where id=1
		Course course2 =(Course)query.select(qcourse.name, qcourse.description).from(qcourse).where(qcourse.id.eq(1)).fetchOne();
		
		//select listado de curso que las horas 
		List<Course> courses=query.select(qcourse).from(qcourse).where(qcourse.hours.between(20, 50)).fetch();
		
		//where dinamico. El parámetro que entra en el where es un predicate y podemos añadirlo así
		
		BooleanBuilder predicateBuilder = new BooleanBuilder(qcourse.description.endsWith("OP"));
		
		if (exits) {
			Predicate predicate2= qcourse.id.eq(1);
			predicateBuilder.and(predicate2);
			
		} else {
			Predicate predicate3 = qcourse.name.endsWith("OP");
			predicateBuilder.and(predicate3);
		}
		Course course3 =(Course)query.select(qcourse.name, qcourse.description).from(qcourse).where(predicateBuilder).fetchOne();
	}
	
	

}
