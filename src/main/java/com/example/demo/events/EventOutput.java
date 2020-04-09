package com.example.demo.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.ApplicationListener;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.example.demo.model.Employee;

@Component
@EnableBinding(EmployeeRegistrationSource.class)
public class EventOutput implements ApplicationListener<PayloadApplicationEvent<?>> {

	EmployeeRegistrationSource employeeRestrationSource;

	public EventOutput(EmployeeRegistrationSource employeeRegistrationSource) {
		this.employeeRestrationSource = employeeRegistrationSource;
	}

	@Override
	public void onApplicationEvent(PayloadApplicationEvent<?> event) {
		Object obj = event.getPayload();

		if (obj instanceof Employee) {
			Employee message = (Employee) obj;
			publishApplicationEvent(message);
		}
	}

	public void publishApplicationEvent(Employee message) {
		System.out.println("start publishApplicationEvent method");
		employeeRestrationSource.employeeRegistration().send(MessageBuilder.withPayload(message).build());
		System.out.println("end publishApplicationEvent method");
	}

}
