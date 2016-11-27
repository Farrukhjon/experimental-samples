/**
 * 
 */
package org.examples.spring.amqp.producer;

import org.examples.spring.amqp.config.RabbitConsumerConfiguration;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public class ProducerDemo {

	public static void main(String[] args) {
		String message = "Hello message";
		ApplicationContext context = new AnnotationConfigApplicationContext(RabbitConsumerConfiguration.class);
		AmqpTemplate amqpTemplate = context.getBean(AmqpTemplate.class);
		amqpTemplate.convertAndSend(message);
		System.out.println("Sent: " + message);
	}

}
