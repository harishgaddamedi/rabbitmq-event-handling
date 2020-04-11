package com.example.demo;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.stereotype.Component;

/*Application Publish Event to publish event messages
 * 
 * @author Harish Gaddameedi
 * */
@Component
public class ApplicationPublishEvent {

	public ApplicationEventPublisher applicationEventPublisher;

	public ApplicationPublishEvent(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}
	
	
	/*method used to publish messages
	 * 
	 * @param payload
	 * */
	public void publishEvent(Object payload) {
		applicationEventPublisher.publishEvent(new PayloadApplicationEvent<>(this, payload));
	}

}
