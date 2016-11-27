/**
 * 
 */
package org.examples.spring.boot.amqp.config;

import org.examples.spring.boot.amqp.handler.ProductHandler;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Farrukhjon SATTOROV
 *
 */
@Configuration
public class POJOAmqpListenerContainerConfiguration {

	public static final String QUEUE_NAME = "app.data.queue.name";
	public static final String EXCHANGE_NAME = "app.data.exchange.name";

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
		template.setMessageConverter(jsonMessageConverter());
		template.setExchange(EXCHANGE_NAME);
		return template;
	}

	@Bean
	public MessageListener messageListener() {
		return new MessageListenerAdapter(productHandler(), jsonMessageConverter());
	}

	@Bean
	public ProductHandler productHandler() {
		return new ProductHandler();
	}

	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
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
