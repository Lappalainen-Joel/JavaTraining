package com.github.lappalainenjoel.javatraining;

import java.io.StringWriter;
import java.util.ArrayList;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class Generator {
	
	public static void main(String[] args) {
		
		// Generate 3 person objects, and give them names.
		Person person1 = new Person();
		Person person2 = new Person();
		Person person3 = new Person();
		
		person1.setName("Dave");
		person2.setName("John");
		person3.setName("Luke");
		
		// Create array of person objects.
		ArrayList<Person> personList = new ArrayList<Person>();
		
		personList.add(person1);
		personList.add(person2);
		personList.add(person3);
		
		// Initialise VelocityEngine, VelocityContext and StringWriter. 
		VelocityEngine velocityEngine = new VelocityEngine();
		velocityEngine.init();
		
		VelocityContext context = new VelocityContext();
		
		StringWriter writer = new StringWriter();
				
		    
		// Declare the first template to use.
		Template t = velocityEngine.getTemplate("\\src\\main\\resources\\test.vm");

		// For the first template: Use 'person1' object as input data. 
		context.put("person", person1);

		// Do the template magic.
		t.merge( context, writer );

		// Show the outcome of processed template.	
		System.out.println(writer);

		// Clean up the context and stringWriter for the next round. (And yes StringWriter's flush -method does not work. Argh.)
		context.remove("person");
		writer.getBuffer().setLength(0);
		
		System.out.println("This is a separator row between template demos.");
		
		// Declare second template to use.
		Template t2 = velocityEngine.getTemplate("\\src\\main\\resources\\test2.vm");

		// For the second template: Use 'personList' array of objects as input data.
		context.put("personList", personList);

		// Do the template magic.
		t2.merge(context, writer);

		// Show the outcome of processed template.
		System.out.println(writer);
		
	}

}
