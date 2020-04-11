package com.example.demo.events;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
/**
 * @author Harish Gaddameedi
 * 
 * interface used create rabbit mq custom channel
 */
public interface PersonRegistrationSource {

	String PERSON_INPUT_CHANNEL = "personRegistrationConsumer";
	String PERSON_OUTPUT_CHANNEL = "personRegistrationProducer";

	@Output(PERSON_OUTPUT_CHANNEL)
	MessageChannel personRegistrationProducer();

	@Input(PERSON_INPUT_CHANNEL)
	MessageChannel personRegistrationConsumer();
}
