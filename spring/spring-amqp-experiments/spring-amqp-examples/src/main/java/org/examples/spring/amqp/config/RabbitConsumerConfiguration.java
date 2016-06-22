package org.examples.spring.amqp.config;

import org.examples.spring.amqp.handler.StringMessageHandler;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Farrukhjon SATTOROV
 *
 */

@Configuration
public class RabbitConsumerConfiguration {
	

	private static final String hostname = "192.168.44.10";
	private static final String virtualHost = "/";
	private static final int port = 5672;
	private static final String queueName = "app.example.queue";
	private static final String username = "guest";
	private static final String password = "guest";

	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory(hostname);
		connectionFactory.setUsername(username);
		connectionFactory.setPassword(password);
		connectionFactory.setHost(hostname);
		connectionFactory.setPort(port);
		connectionFactory.setVirtualHost(virtualHost);
		return connectionFactory;
	}

	@Bean
	public SimpleMessageListenerContainer stringMessageListenerContainer() {
		SimpleMessageListenerContainer messageListenerContainer = new SimpleMessageListenerContainer(connectionFactory());
		messageListenerContainer.setQueues(queue());
		messageListenerContainer.setMessageListener(stringMessageListenerAdapter());
		messageListenerContainer.setMessageConverter(simpleMessageConverter());
		return messageListenerContainer;
	}
	
	@Bean
	public MessageListener stringMessageListenerAdapter() {
		return new MessageListenerAdapter(new StringMessageHandler());
	}
	
	@Bean
	public MessageConverter simpleMessageConverter(){
		return new SimpleMessageConverter();
	}

	@Bean
	public RabbitTemplate rabbitTemplate() {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
		rabbitTemplate.setRoutingKey(queueName);
		rabbitTemplate.setMessageConverter(simpleMessageConverter());
		return rabbitTemplate;
	}

	@Bean
	public Queue queue() {
		return new Queue(queueName);
	}

	@Bean
	public Exchange exchange() {
		return new DirectExchange("app.direct.exchange");
	}

}
