/**
 * 
 */
package org.examples.spring.amqp.consumer;

import org.examples.spring.amqp.config.RabbitConsumerConfiguration;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public class ConsumerDemo {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(RabbitConsumerConfiguration.class);
		AmqpTemplate amqpTemplate = context.getBean(AmqpTemplate.class);
		System.out.println(amqpTemplate.receiveAndConvert());
	}

}
