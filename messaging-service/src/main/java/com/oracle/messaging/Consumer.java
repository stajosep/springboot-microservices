package com.oracle.messaging;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

	public Consumer() {
		// TODO Auto-generated constructor stub
	}
	
	@JmsListener(destination="sample.queue")
	public void receiveQueueMessage(String text) {
		System.out.println("Output \n");
		System.out.println(text);
	}

}
