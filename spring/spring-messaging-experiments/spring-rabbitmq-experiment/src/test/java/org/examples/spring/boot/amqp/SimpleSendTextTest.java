/**
 * 
 */
package org.examples.spring.boot.amqp;

import java.util.UUID;

import org.examples.spring.boot.amqp.config.SimpleAmqpListenerContainerConfiguration;
import org.junit.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.MessagePropertiesBuilder;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public class SimpleSendTextTest extends BaseJUnitTest {

	private String EXCHANGE_NAME = SimpleAmqpListenerContainerConfiguration.EXCHANGE_NAME;
	private String QUEUE_NAME = SimpleAmqpListenerContainerConfiguration.QUEUE_NAME;
	
	private byte[] data = "This is a simple text".getBytes();
	
	@Test
	public void testSimpleMessageSendByRoutingKey(){
		MessageProperties prop = MessagePropertiesBuilder
				.newInstance()
				.setCorrelationId(UUID.randomUUID().toString().getBytes())
				.setContentType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN)
				.build();
		
		Message message = MessageBuilder.withBody(data)
				.andProperties(prop)
				.build();
		rabbitTemplate.send(EXCHANGE_NAME, QUEUE_NAME, message);
	}
	

}
