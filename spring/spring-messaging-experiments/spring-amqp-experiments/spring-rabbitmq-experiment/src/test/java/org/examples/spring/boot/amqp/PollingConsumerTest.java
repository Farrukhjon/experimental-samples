/**
 * 
 */
package org.examples.spring.boot.amqp;

import org.junit.Test;
import org.springframework.amqp.core.Message;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public class PollingConsumerTest extends BaseJUnitTest {

	private String queueName = "app.example.queue";

	@Test
	public void testReceiveMethod() {
		Message msg = rabbitTemplate.receive();
		assertNotNull(msg);
	}

	@Test
	public void testReceiveByQueueNameMethod() {
		Message msg = rabbitTemplate.receive(queueName);
		assertNotNull(msg);
	}

	@Test
	public void testReceiveAndConvertMethod() {
		Object object = rabbitTemplate.receiveAndConvert();
		assertNotNull(object);
	}

	@Test
	public void testReceiveAndConvertByQueueNameMethod() {
		Object object = rabbitTemplate.receiveAndConvert(queueName);
		assertNotNull(object);
	}

}
