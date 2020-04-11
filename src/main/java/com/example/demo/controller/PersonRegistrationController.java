package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ApplicationPublishEvent;
import com.example.demo.model.Employee;
import com.example.demo.model.Student;
/**
 * @author Harish Gaddameedi
 * 
 * controller to control persons registrations
 */
@RestController
@RequestMapping("/register")
public class PersonRegistrationController {

	@Autowired
	ApplicationPublishEvent applicationPublishEvent;

	@RequestMapping("/student")
	public String registerStudent(@RequestBody Student student) {
		applicationPublishEvent.publishEvent(student);
		System.out.println(student.toString());
		return "Student Registered";
	}

	@RequestMapping("/employee")
	public String registerEmployee(@RequestBody Employee employee) {
		applicationPublishEvent.publishEvent(employee);
		System.out.println(employee.toString());
		return "Employee Registered";
	}
}
