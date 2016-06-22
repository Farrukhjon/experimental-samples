/**
 * 
 */
package org.examples.spring.amqp.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public class XmlConnectionFactoryDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext context = new GenericXmlApplicationContext("rabbitmq-context.xml");
		AmqpTemplate template = context.getBean(AmqpTemplate.class);

		template.convertAndSend("myqueue", "foo");

		String foo = (String) template.receiveAndConvert("myqueue");
		System.out.println(foo);
	}

}
