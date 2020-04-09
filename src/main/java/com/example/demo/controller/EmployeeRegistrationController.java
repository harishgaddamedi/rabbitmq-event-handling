package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ApplicationPublishEvent;
import com.example.demo.events.EmployeeRegistrationSource;
import com.example.demo.model.Employee;

@RestController
public class EmployeeRegistrationController {

	@Autowired
	ApplicationPublishEvent applicationPublishEvent;

	@RequestMapping("/register")
	public String orderFood(@RequestBody Employee employee) {
		applicationPublishEvent.publishEvent(employee);
		System.out.println(employee.toString());
		return "Employee Registered";
	}

}
