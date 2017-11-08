package io.github.yexiaoxiaogo.ActiveMQ;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
	
	@JmsListener(destination = "mailbox", containerFactory = "myFactory")
	private void receiveQueue(String text) {
		System.out.println("text:" + text);

	}

}
