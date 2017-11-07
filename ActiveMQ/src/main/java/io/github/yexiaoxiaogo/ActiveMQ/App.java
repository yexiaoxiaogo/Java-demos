package io.github.yexiaoxiaogo.ActiveMQ;



import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class App 
{
	@Bean
	public Queue queue(){
		return new ActiveMQQueue("sample.queue");
	}
    public static void main( String[] args )
    {
    	System.out.println("hi");
        SpringApplication.run(App.class, args);
        
    }
}
