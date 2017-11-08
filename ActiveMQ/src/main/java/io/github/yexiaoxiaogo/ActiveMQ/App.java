package io.github.yexiaoxiaogo.ActiveMQ;



import javax.jms.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@SpringBootApplication
@EnableJms
public class App 
{
	@Bean
	public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,DefaultJmsListenerContainerFactoryConfigurer configurer){
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        
        return factory;
	}
	 @Bean 
	    public MessageConverter jacksonJmsMessageConverter() {
	        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
	        converter.setTargetType(MessageType.TEXT);
	        converter.setTypeIdPropertyName("_type");
	        return converter;
	    }

    public static void main( String[] args )
    {
    	ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
    	JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
    	System.out.println("Sending an email message.");
    	jmsTemplate.convertAndSend("mailbox", new String("Hello"));
    }
}
