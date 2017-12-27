package com.acilia.ttschool.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.acilia.ttschool.model.Persona;
import com.acilia.ttschool.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {

	private static final Log LOGGER = LogFactory.getLog(ExampleServiceImpl.class);
	@Override
	public List<Persona> getListPeople() {
		LOGGER.info("GETLISTPEOPLE SERVICE");
		List<Persona> personas = new ArrayList<Persona>();
		personas.add(new Persona("Alicia",35));
		personas.add(new Persona("Alejandro",7));
		return personas;
	}

}
