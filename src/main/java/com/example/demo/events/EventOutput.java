package com.example.demo.events;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.ApplicationListener;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.example.demo.model.Employee;
import com.example.demo.model.Student;

/*Application Publish Event to publish messages to rabbit mq
 * 
 * @author Harish Gaddameedi
 * */
@Component
@EnableBinding(PersonRegistrationSource.class)
public class EventOutput implements ApplicationListener<PayloadApplicationEvent<?>> {

	PersonRegistrationSource personRestrationSource;

	public EventOutput(PersonRegistrationSource personRegistrationSource) {
		this.personRestrationSource = personRegistrationSource;
	}

	@Override
	public void onApplicationEvent(PayloadApplicationEvent<?> event) {
		Object obj = event.getPayload();
		publishApplicationEvent(obj);
	}

	private void publishApplicationEvent(Object object) {
		System.out.println("start publishApplicationEvent method");
		personRestrationSource.personRegistrationProducer().send(MessageBuilder.withPayload(object).build());
		System.out.println("end publishApplicationEvent method");
	}

}
