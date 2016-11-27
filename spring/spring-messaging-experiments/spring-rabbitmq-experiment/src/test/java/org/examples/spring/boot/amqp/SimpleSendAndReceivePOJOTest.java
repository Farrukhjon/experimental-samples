/**
 * 
 */
package org.examples.spring.boot.amqp;

import java.util.UUID;

import org.examples.spring.boot.amqp.dto.ProductRequest;
import org.junit.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.MessagePropertiesBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public class SimpleSendAndReceivePOJOTest extends BaseJUnitTest {

	@Test
	public void testSendingJSONMessage() throws JsonProcessingException {
		MessageProperties prop = MessagePropertiesBuilder
				.newInstance()
				.setCorrelationId(UUID.randomUUID().toString().getBytes())
				.setContentType(MessageProperties.CONTENT_TYPE_JSON)
				.build();
		
		ProductRequest obj = new ProductRequest("get-products", 100.0);
		String jsonObj = new ObjectMapper().writeValueAsString(obj);
		
		Message result = rabbitTemplate.sendAndReceive(EXCHANGE_NAME, QUEUE_NAME, new Message(jsonObj.getBytes(), prop));
		
		assertNotNull(result);
	}
	

}
