/**
 * 
 */
package org.examples.spring.amqp;

import junit.framework.TestCase;

import org.examples.spring.amqp.config.RabbitConsumerConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public class BaseJUnitTest extends TestCase {
	
	protected ApplicationContext getContext(){
		return new AnnotationConfigApplicationContext(RabbitConsumerConfiguration.class);
	}

	
	
}
