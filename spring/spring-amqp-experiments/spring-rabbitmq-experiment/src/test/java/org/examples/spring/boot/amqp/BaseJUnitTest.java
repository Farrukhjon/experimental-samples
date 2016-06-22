/**
 * 
 */
package org.examples.spring.boot.amqp;

import junit.framework.TestCase;

import org.examples.spring.boot.amqp.config.POJOAmqpListenerContainerConfiguration;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Farrukhjon SATTOROV
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class BaseJUnitTest extends TestCase {
	
	protected final String EXCHANGE_NAME = POJOAmqpListenerContainerConfiguration.EXCHANGE_NAME;
	protected final String QUEUE_NAME = POJOAmqpListenerContainerConfiguration.QUEUE_NAME;
	
	@Autowired
	protected ConnectionFactory connectionFactory;

	@Autowired
	protected RabbitTemplate rabbitTemplate;

	@Autowired
	protected RabbitAdmin rabbitAdmin;
	
}
