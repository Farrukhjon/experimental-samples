/**
 * 
 */
package org.examples.spring.boot.amqp;

import junit.framework.Assert;

import org.junit.Test;
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
public class DefaultRabbitConfigurationTest {

	@Autowired
	private ConnectionFactory connectionFactory;

	@Autowired
	private RabbitTemplate template;

	@Autowired
	private RabbitAdmin rabbitAdmin;

	@Test
	public void testconnectionFactoryIfItInjectedCorrectly() {
		Assert.assertNotNull(connectionFactory);
	}

	@Test
	public void testTemplateIfItInjectedCorrectly() {
		Assert.assertNotNull(template);
	}

	@Test
	public void testRabbitAdminIfItInjectedCorrectly() {
		Assert.assertNotNull(rabbitAdmin);
	}

}
