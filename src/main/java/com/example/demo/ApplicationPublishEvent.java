package com.example.demo;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationPublishEvent {

	public ApplicationEventPublisher applicationEventPublisher;

	public ApplicationPublishEvent(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}

	public void publishEvent(Object payload) {
		applicationEventPublisher.publishEvent(new PayloadApplicationEvent<>(this, payload));
	}

}
