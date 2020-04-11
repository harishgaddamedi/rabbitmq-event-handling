package com.example.demo.events;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import com.example.demo.model.Employee;
import com.example.demo.model.Student;

/*application publish event to listen messages from queue
 * 
 * @author Harish Gaddameedi
 * */
@Component
@EnableBinding(PersonRegistrationSource.class)
public class EventInput {

	@StreamListener(PersonRegistrationSource.PERSON_INPUT_CHANNEL)
	public void processRegisterStudent(Object object) {
		System.out.println("Person Registered by Client " + object);
	}

}
