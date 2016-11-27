/**
 * 
 */
package org.examples.spring.boot.amqp.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Farrukhjon SATTOROV
 *
 */
@Configuration
public class SimpleAmqpListenerContainerConfiguration {

	public static final String QUEUE_NAME = "app.text.queue.name";
	public static final String EXCHANGE_NAME = "app.text.exchange.name";

	@Autowired
	protected ConnectionFactory connectionFactory;

	@Bean
	public SimpleMessageListenerContainer messageListenerContainer() {
		SimpleMessageListenerContainer listenerContainer = new SimpleMessageListenerContainer(connectionFactory);
		listenerContainer.setMessageListener(messageListener());
		listenerContainer.addQueues(queue());
		return listenerContainer;
	}

	@Bean
	public RabbitTemplate rabbitTemplate() {
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		template.setExchange(EXCHANGE_NAME);
		return template;
	}

	@Bean
	public MessageListener messageListener() {
		return new MessageListener() {
			@Override
			public void onMessage(Message message) {
				System.out.println(message);
			}
		};
	}

	@Bean
	public Queue queue() {
		return new Queue(QUEUE_NAME);
	}

	@Bean
	public Exchange exchange() {
		return new DirectExchange(EXCHANGE_NAME);
	}

	@Bean
	public Binding binding() {
		return BindingBuilder.bind(queue()).to(exchange()).with(QUEUE_NAME).noargs();
	}

}
